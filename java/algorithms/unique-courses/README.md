# Sorted Unique Courses

Reads course records from a text file and prints each distinct course name in sorted order.

A revised version of a Java coursework exercise. The sample file uses fictional DEMO identifiers.

## What it does

- Uses a TreeSet for deduplication and ordering.
- Accepts whitespace-separated identifiers and course names.
- Handles blank lines and reports rows missing a course token.
- Reads UTF-8 input and reports file errors.

## Run

Use a JDK with `javac` and `java` on your command path. These commands are run from the project folder; create `build` only if it does not already exist.

```text
mkdir build
javac -proc:none -encoding UTF-8 -d build src/Program1.java
java -cp build Program1
```

The included file contains repeated Math and Science entries and prints [History, Math, Science].

## Input file

`classes.txt` is included as sample data. Each nonblank UTF-8 line contains an identifier followed by a single-token course name. Fields are separated by whitespace. Additional fields are ignored.

The default file is read from the working directory. To use another file, pass its path after the class name:

```text
java -cp build Program1 path/to/input.txt
```

## Notes

- A course name is one case-sensitive token.
- Only the second token on each line is collected; later fields are ignored.
- This lists course names and does not manage enrollment.

## Checks

The current version passed 10 recorded runtime scenarios on Temurin JDK 21 for Windows. The checks covered normal inputs and relevant error or boundary cases. This does not guarantee behavior for every input or platform.

[Back to the project index](../../../README.md)
