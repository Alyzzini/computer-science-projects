# Bank Account Collection Exercise

Demonstrates object arrays, deposits and withdrawals, balance totals, filtering, and a name lookup using fictional bank accounts.

The tester is a revised coursework exercise. The missing BankAccount dependency was reconstructed from its constructor and method calls. Account names and identifiers are fictional examples.

## What it does

- Runs a fixed example with five sample accounts.
- Totals balances and lists accounts above a balance threshold.
- Builds a new array without accounts that have negative balances.
- Includes a minimal BankAccount class with input and overflow checks.

## Run

Use a JDK with `javac` and `java` on your command path. These commands are run from the project folder; create `build` only if it does not already exist.

```text
mkdir build
javac -proc:none -encoding UTF-8 -d build src/BankAccount.java src/BankAccountTester.java
java -cp build BankAccountTester
```

The example deposits 100 into the first account and withdraws 200 from the second. The resulting total is 74041.00; removing negative balances leaves four accounts.

## Sample data

The sample accounts are defined directly in BankAccountTester.java. Names and identifiers are fictional; the exercise balances are retained from the tester.

## Notes

- BankAccount is a reconstructed dependency based on the tester interface; the original class was missing.
- Negative balances are allowed so the filtering example has an overdraft to remove.
- Balances use double values; this is an object-and-array exercise, not financial software.
- Account data is held in memory and is not saved.

## Checks

The current version passed 2 recorded runtime scenarios on Temurin JDK 21 for Windows. The checks covered normal inputs and relevant error or boundary cases. This does not guarantee behavior for every input or platform.

[Back to the project index](../../../README.md)
