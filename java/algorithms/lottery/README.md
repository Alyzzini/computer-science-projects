# Lottery Digit Matching

A small console game that compares a two-digit guess with a random two-digit draw.

A revised version of a Java coursework exercise.

## What it does

- Draws an integer from 10 through 99.
- Distinguishes an exact match, reversed digits, one matching digit, and no match.
- Validates guesses before comparing digits.

Exact matches print $10000, reversed digits print $3000, and a single matching digit prints $100.

## Run

Use a JDK with `javac` and `java` on your command path. These commands are run from the project folder; create `build` only if it does not already exist.

```text
mkdir build
javac -proc:none -encoding UTF-8 -d build src/Program3_Lottery.java
java -cp build Program3_Lottery
```

Enter a two-digit guess such as 42. The program shows the random draw and the matching result.

## Notes

- The draw changes between runs, so a fixed guess does not guarantee a prize branch.
- The printed prizes are fictional game output.

## Checks

The current version passed 14 recorded runtime scenarios on Temurin JDK 21 for Windows. The checks covered normal inputs and relevant error or boundary cases. This does not guarantee behavior for every input or platform.

[Back to the project index](../../../README.md)
