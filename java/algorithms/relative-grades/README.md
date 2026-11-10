# Relative Grade Calculator

Reads a group of scores and assigns letter grades relative to the highest score in the group.

A revised version of a Java coursework exercise.

## What it does

- Stores scores in an integer array and finds the highest value.
- Assigns A, B, C, D, or F using ten-point bands below the best score.
- Validates the number of students and every score before reporting grades.

## Run

Use a JDK with `javac` and `java` on your command path. These commands are run from the project folder; create `build` only if it does not already exist.

```text
mkdir build
javac -proc:none -encoding UTF-8 -d build src/Program2.java
java -cp build Program2
```

For scores 100, 90, 80, 70, 60, and 59, the grades are A, A, B, C, D, and F.

## Notes

- Accepts 1 through 10000 students; this cap was added to the revised version.
- Scores may be any nonnegative int, including values above 100.
- Output uses zero-based student numbers rather than names.

## Checks

The current version passed 17 recorded runtime scenarios on Temurin JDK 21 for Windows. The checks covered normal inputs and relevant error or boundary cases. This does not guarantee behavior for every input or platform.

[Back to the project index](../../../README.md)
