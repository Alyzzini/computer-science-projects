# Balanced Delimiter Validator

Checks whether parentheses, brackets, braces, and angle brackets are balanced and correctly nested.

A revised version of a Java coursework exercise. The included expressions are new sample data.

## What it does

- Uses a stack to match opening and closing delimiters.
- Checks one expression per nonblank UTF-8 line.
- Ignores an existing annotation after the first ==> marker.
- Reports file-open and file-read errors.

## Run

Use a JDK with `javac` and `java` on your command path. These commands are run from the project folder; create `build` only if it does not already exist.

```text
mkdir build
javac -proc:none -encoding UTF-8 -d build src/Main.java
java -cp build Main
```

(a+[b*{c}]) is valid, while ([)] is invalid because the nesting order does not match.

## Input file

`expressions.txt` is included as sample data. One expression per nonblank UTF-8 line. Text after the first ==> marker is treated as an annotation and ignored. Recognized pairs are (), [], {}, and <>.

The default file is read from the working directory. To use another file, pass its path after the class name:

```text
java -cp build Main path/to/input.txt
```

## Notes

- Only delimiter balance is checked; quotes, comments, HTML semantics, and expression grammar are not parsed.
- Characters other than the four delimiter pairs are ignored.
- Empty strings are balanced at the method level; blank input lines are skipped.
- A late file error may be reported after earlier expression results have already printed.

## Checks

The current version passed 11 recorded runtime scenarios on Temurin JDK 21 for Windows. The checks covered normal inputs and relevant error or boundary cases. This does not guarantee behavior for every input or platform.

[Back to the project index](../../../README.md)
