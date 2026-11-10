# Six Recursive Methods

A console demonstration of recursive counting, summation, digit counting, and digit summation.

This runnable wrapper was reconstructed from six written recursion answers. The wrapper, distinct method names, input validation, and 0-100 bound were added while preparing the standalone version.

## What it does

- Prints descending and ascending sequences.
- Counts down by two, including zero when the starting value is even.
- Sums the integers from 1 through the chosen bound.
- Counts and sums digits for positive, negative, and zero integer inputs.

## Run

Use a JDK with `javac` and `java` on your command path. These commands are run from the project folder; create `build` only if it does not already exist.

```text
mkdir build
javac -proc:none -encoding UTF-8 -d build src/RecursionExercises.java
java -cp build RecursionExercises
```

With sequence bound 5 and digit input 126, the sum is 15, the digit count is 3, and the digit sum is 9.

## Notes

- Sequence inputs are limited to 0 through 100 to keep output and recursion depth manageable.
- Digit operations accept signed 32-bit integers and ignore the minus sign.
- The wrapper and method names are reconstructed from written answers, not a recovered standalone source file.

## Checks

The current version passed 14 recorded runtime scenarios on Temurin JDK 21 for Windows. The checks covered normal inputs and relevant error or boundary cases. This does not guarantee behavior for every input or platform.

[Back to the project index](../../../README.md)
