#!/usr/bin/env python3
"""List, build, and run the Java projects in this repository.

Examples:
    python tools/projects.py list
    python tools/projects.py build all
    python tools/projects.py --java-home /path/to/jdk run project-id -- argument

Requires Python 3.9+ and a JDK 17+. Builds only write to .build/<id>.
Project IDs may have one or two segments, such as algorithms/gratuity.
Running a program uses its project folder as the working directory. Programs
that save files may therefore create or update their documented data files.
"""
import argparse
import json
import os
from pathlib import Path, PureWindowsPath
import re
import shutil
import subprocess
import sys


class ProjectError(Exception):
    """An error that can be explained without a Python traceback."""


def within(path, parent):
    try:
        path.resolve().relative_to(parent.resolve())
        return True
    except ValueError:
        return False


def load_projects(root):
    try:
        entries = json.loads((root / 'projects.json').read_text(encoding='utf-8'))
    except (OSError, UnicodeError, json.JSONDecodeError) as error:
        raise ProjectError('Cannot read projects.json: ' + str(error)) from error
    if not isinstance(entries, list):
        raise ProjectError('projects.json must contain an array of projects.')
    seen = set()
    projects = []
    reserved = {'all', 'con', 'prn', 'aux', 'nul'}
    reserved.update('com' + str(n) for n in range(1, 10))
    reserved.update('lpt' + str(n) for n in range(1, 10))
    for entry in entries:
        if not isinstance(entry, dict) or any(not isinstance(entry.get(key), str) or not entry[key].strip()
                                             for key in ('id', 'name', 'path', 'mainClass', 'kind')):
            raise ProjectError('Each project needs id, name, path, mainClass, and kind strings.')
        identifier = entry['id']
        segments = identifier.split('/')
        if (not 1 <= len(segments) <= 2
                or any(not re.fullmatch(r'[A-Za-z0-9][A-Za-z0-9_-]{0,99}', segment)
                       or segment.lower() in reserved for segment in segments)):
            raise ProjectError('Invalid project ID: ' + identifier)
        if identifier.casefold() in seen:
            raise ProjectError('Duplicate project ID: ' + identifier)
        seen.add(identifier.casefold())
        relative = entry['path']
        if ('\\' in relative or PureWindowsPath(relative).drive or Path(relative).is_absolute()
                or any(part in ('', '.', '..') for part in relative.split('/'))):
            raise ProjectError('Project paths must be safe relative paths: ' + relative)
        project = root / relative
        if not within(project, root) or within(project, root / '.build') or not project.is_dir():
            raise ProjectError('Project path is missing or outside the project tree: ' + relative)
        if entry['kind'] != 'Java':
            raise ProjectError('Unsupported project kind for ' + identifier + ': ' + entry['kind'])
        if not re.fullmatch(r'[A-Za-z_$][A-Za-z0-9_$]*(\.[A-Za-z_$][A-Za-z0-9_$]*)*', entry['mainClass']):
            raise ProjectError('Invalid main class for ' + identifier)
        projects.append(dict(entry, directory=project.resolve()))
    return projects


def find_jdk(java_home):
    home = java_home or os.environ.get('JAVA_HOME')
    suffix = '.exe' if os.name == 'nt' else ''
    if home:
        base = Path(home).expanduser().resolve() / 'bin'
        compiler, runtime = base / ('javac' + suffix), base / ('java' + suffix)
        if not compiler.is_file() or not runtime.is_file():
            raise ProjectError('The selected JDK must contain bin/javac and bin/java. Check --java-home or JAVA_HOME.')
    else:
        compiler, runtime = shutil.which('javac'), shutil.which('java')
        if not compiler or not runtime:
            raise ProjectError('JDK not found. Set JAVA_HOME, use --java-home, or put javac and java on PATH.')
        compiler, runtime = Path(compiler), Path(runtime)
    try:
        version = subprocess.run([str(compiler), '-version'], capture_output=True, text=True, timeout=15)
    except (OSError, subprocess.TimeoutExpired) as error:
        raise ProjectError('Cannot check the selected Java compiler: ' + str(error)) from error
    match = re.search(r'javac\s+(\d+)', version.stdout + version.stderr)
    if version.returncode or not match or int(match.group(1)) < 17:
        raise ProjectError('Use JDK 17 or newer for this launcher.')
    return compiler, runtime


def input_files(directory, name, required=False):
    base = directory / name
    if not base.exists():
        if required:
            raise ProjectError('Missing ' + name + ' folder in ' + directory.name)
        return []
    if not base.is_dir() or base.is_symlink() or not within(base, directory):
        raise ProjectError('Unsafe ' + name + ' folder in ' + directory.name)
    result = []
    for path in sorted(base.rglob('*')):
        if path.is_symlink() or not within(path, base):
            raise ProjectError('Linked or escaping source/resource path: ' + str(path))
        if path.is_file():
            result.append(path)
    return result


def build_project(root, project, compiler):
    directory = project['directory']
    sources = [p for p in input_files(directory, 'src', required=True) if p.suffix == '.java']
    if not sources:
        raise ProjectError('No Java source files for ' + project['id'])
    resources = input_files(directory, 'resources')
    if any(p.suffix.lower() == '.class' for p in resources):
        raise ProjectError('Resources cannot contain compiled .class files: ' + project['id'])
    build_root = root / '.build'
    destination = build_root / project['id']
    if (build_root.is_symlink() or destination.is_symlink()
            or build_root.resolve() != build_root or destination.resolve() != destination
            or not within(build_root, root) or not within(destination, build_root)):
        raise ProjectError('Unsafe build directory for ' + project['id'])
    if destination.exists():
        if not destination.is_dir() or any(p.is_symlink() for p in destination.rglob('*')):
            raise ProjectError('Build output must be an ordinary directory without linked files.')
        shutil.rmtree(destination)
    destination.mkdir(parents=True)
    command = [str(compiler), '-proc:none', '--release', '8', '-encoding', 'UTF-8',
               '-d', str(destination)] + [str(p) for p in sources]
    result = subprocess.run(command, cwd=directory)
    if result.returncode:
        raise ProjectError('Compilation failed for ' + project['id'])
    for source in resources:
        target = destination / source.relative_to(directory / 'resources')
        if not within(target, destination) or target.exists():
            raise ProjectError('Resource conflicts with generated output: ' + str(source))
        target.parent.mkdir(parents=True, exist_ok=True)
        shutil.copy2(source, target)
    print('Built ' + project['id'], flush=True)
    return destination


def main(argv=None):
    parser = argparse.ArgumentParser(description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter)
    parser.add_argument('--java-home', help='JDK root folder; defaults to JAVA_HOME, then PATH')
    commands = parser.add_subparsers(dest='command', required=True)
    commands.add_parser('list', help='list available projects')
    build = commands.add_parser('build', help='compile one project or all projects')
    build.add_argument('project', help='project ID or all')
    run = commands.add_parser('run', help='build and run a project from its own folder')
    run.add_argument('project', help='project ID')
    run.add_argument('arguments', nargs=argparse.REMAINDER, help='arguments passed to the Java program')
    args = parser.parse_args(argv)
    root = Path(__file__).resolve().parents[1]
    try:
        projects = load_projects(root)
        if args.command == 'list':
            for project in projects:
                print(project['id'] + '\t' + project['name'] + '\t' + project['path'])
            return 0
        if args.command == 'build' and args.project == 'all':
            selected = projects
        else:
            selected = [p for p in projects if p['id'] == args.project]
            if not selected:
                raise ProjectError('Unknown project ID: ' + args.project + '. Use list to see available IDs.')
        compiler, runtime = find_jdk(args.java_home)
        failures = 0
        destination = None
        for project in selected:
            try:
                destination = build_project(root, project, compiler)
            except (ProjectError, OSError) as error:
                print('error: ' + str(error), file=sys.stderr)
                failures += 1
        if failures:
            return 1
        if args.command == 'build':
            return 0
        arguments = args.arguments[1:] if args.arguments[:1] == ['--'] else args.arguments
        result = subprocess.run([str(runtime), '-cp', str(destination), selected[0]['mainClass']] + arguments,
                                cwd=selected[0]['directory'])
        return result.returncode if result.returncode >= 0 else 1
    except (ProjectError, OSError) as error:
        print('error: ' + str(error), file=sys.stderr)
        return 2
    except KeyboardInterrupt:
        print('\nStopped.', file=sys.stderr)
        return 130


if __name__ == '__main__':
    raise SystemExit(main())
