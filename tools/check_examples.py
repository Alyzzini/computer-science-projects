#!/usr/bin/env python3
"""Run five small console examples with Python 3.9+ and JDK 17+.

    python tools/check_examples.py
    python tools/check_examples.py --java-home /path/to/jdk

The launcher rebuilds the selected programs in .build. Sample input files are
read without being changed, and the phone-directory workflow stays in memory.
Each build/run has a 45-second timeout. These examples are not an exhaustive
test suite or a performance benchmark.
"""
import argparse
import os
from pathlib import Path
import signal
import subprocess
import sys


CASES = [
    {
        'id': 'algorithms/stack-partition',
        'expected': '[-4, -2, 5, 0, 3]\n[3, 2, 1]\n[-3, -2, -1]\n',
    },
    {
        'id': 'algorithms/delimiter-validation',
        'expected': '(a+[b*{c}]) ==> valid\n<tag>{[()]}</tag> ==> valid\n'
                    '([)] ==> invalid\n)abc( ==> invalid\nno delimiters ==> valid\n'
                    '<[{}]> ==> valid\n(unclosed ==> invalid\n[x] ==> valid\n',
    },
    {
        'id': 'algorithms/unique-courses',
        'expected': '[History, Math, Science]\n',
    },
    {
        'id': 'algorithms/regional-vote-tally',
        'expected': 'CandidateA won the election.\n\n'
                    'Nobody won! A special runoff election will be held.\n\n'
                    'Nobody won! A special runoff election will be held.\n\n'
                    'Nobody won! A special runoff election will be held.\n',
    },
    {
        'id': 'applications/phone-directory',
        'input': '2\nDemo Visitor\n2025550117\n1\ndemo visitor\n'
                 '3\nDemo Visitor\n3035550118\n1\nDemo Visitor\n'
                 '6\nDemo Visitor\n1\nDemo Visitor\n8\n',
        'ordered': ['Member successfully added', 'Demo Visitor  202-555-0117',
                    'Phone number updated successfully.', 'Demo Visitor  303-555-0118',
                    'Member removed from the phone directory.',
                    'Member not found in the phone directory.', 'Exiting the program...'],
    },
]


def stop_process_tree(process):
    if os.name == 'nt':
        subprocess.run(['taskkill', '/PID', str(process.pid), '/T', '/F'],
                       stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL,
                       creationflags=subprocess.CREATE_NO_WINDOW, timeout=5)
    else:
        try:
            os.killpg(process.pid, signal.SIGKILL)
        except ProcessLookupError:
            pass
    if process.poll() is None:
        process.kill()


def run_case(root, case, java_home=None):
    command = [sys.executable, str(root / 'tools/projects.py')]
    if java_home:
        command += ['--java-home', java_home]
    command += ['run', case['id']]
    options = {'start_new_session': True} if os.name != 'nt' else {
        'creationflags': subprocess.CREATE_NO_WINDOW | subprocess.CREATE_NEW_PROCESS_GROUP}
    try:
        process = subprocess.Popen(command, cwd=root, stdin=subprocess.PIPE,
                                   stdout=subprocess.PIPE, stderr=subprocess.PIPE,
                                   text=True, encoding='utf-8', errors='replace', **options)
        try:
            output, errors = process.communicate(case.get('input', ''), timeout=45)
        except subprocess.TimeoutExpired:
            stop_process_tree(process)
            process.communicate(timeout=5)
            return False, 'Build or program exceeded the 45-second timeout.'
    except (OSError, subprocess.SubprocessError) as error:
        return False, str(error)
    if process.returncode != 0:
        return False, 'Nonzero exit status: ' + str(process.returncode) + '\n' + (output + errors)[-4000:]
    output = output.replace('\r\n', '\n')
    progress = 'Built ' + case['id'] + '\n'
    if output.startswith(progress):
        output = output[len(progress):]
    if 'expected' in case:
        if output != case['expected']:
            return False, 'Expected:\n' + case['expected'] + 'Actual:\n' + output[-4000:]
    else:
        position = 0
        for fragment in case['ordered']:
            found = output.find(fragment, position)
            if found < 0:
                return False, 'Missing or out-of-order workflow result: ' + fragment + '\n' + output[-4000:]
            position = found + len(fragment)
        if 'Input ended.' in output or 'Member already exists' in output:
            return False, 'The phone-directory workflow did not complete as intended.\n' + output[-4000:]
    return True, ''


def main(argv=None):
    parser = argparse.ArgumentParser(description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter)
    parser.add_argument('--java-home', help='optional JDK root passed to the project launcher')
    args = parser.parse_args(argv)
    root = Path(__file__).resolve().parents[1]
    passed = 0
    for case in CASES:
        success, detail = run_case(root, case, args.java_home)
        print(('PASS ' if success else 'FAIL ') + case['id'], flush=True)
        if success:
            passed += 1
        else:
            print(detail, file=sys.stderr, flush=True)
    print(str(passed) + '/' + str(len(CASES)) + ' examples passed.')
    return 0 if passed == len(CASES) else 1


if __name__ == '__main__':
    raise SystemExit(main())
