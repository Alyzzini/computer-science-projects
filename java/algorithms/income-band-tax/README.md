# Income Band Tax Exercise

A Java console exercise that selects a rate from five income bands and rounds the resulting tax to the nearest dollar.

A revised version of a Java coursework exercise.

## What it does

- Chooses a rate using conditional branches.
- Rounds the calculated amount to a whole dollar.
- Rejects invalid income and results outside the supported range.

The rates are 0% through 5000, 3% above 5000 through 10000, 5.5% above 10000 through 20000, 10.8% above 20000 through 40000, and 23.7% above 40000.

## Run

Use a JDK with `javac` and `java` on your command path. These commands are run from the project folder; create `build` only if it does not already exist.

```text
mkdir build
javac -proc:none -encoding UTF-8 -d build src/Program2_Tax.java
java -cp build Program2_Tax
```

An income of 10000 produces 300. An income of 20000 produces 1100.

## Notes

- These are classroom rates, not current tax rules.
- The selected rate applies to the whole income; this is not a progressive bracket calculation.
- Uses double arithmetic.

## Checks

The current version passed 21 recorded runtime scenarios on Temurin JDK 21 for Windows. The checks covered normal inputs and relevant error or boundary cases. This does not guarantee behavior for every input or platform.

[Back to the project index](../../../README.md)
