# Gratuity Calculator

A console calculator that takes a subtotal and tip percentage, then prints the gratuity and total.

A revised version of a Java coursework exercise.

## What it does

- Accepts decimal subtotals and percentages.
- Formats the gratuity and total with up to two decimal places.
- Reports invalid, negative, nonfinite, missing, or overflowing input.

## Run

Use a JDK with `javac` and `java` on your command path. These commands are run from the project folder; create `build` only if it does not already exist.

```text
mkdir build
javac -proc:none -encoding UTF-8 -d build src/Program1_Gratuity.java
java -cp build Program1_Gratuity
```

Enter 15 for the subtotal and 10 for the percentage. The program prints a gratuity of $1.5 and a total of $16.5.

## Notes

- Uses double arithmetic for a classroom calculation; amounts are rounded for display.

## Checks

The current version passed 17 recorded runtime scenarios on Temurin JDK 21 for Windows. The checks covered normal inputs and relevant error or boundary cases. This does not guarantee behavior for every input or platform.

[Back to the project index](../../../README.md)
