# Account Model

A small account class with balance operations, interest calculations, and a console demonstration.

## What it does

- Encapsulated balance and interest rate
- Deposit and withdrawal validation
- Overdraft and overflow checks
- Defensive copies of creation dates

## Run

From this folder with a JDK installed, in PowerShell:

```powershell
New-Item -ItemType Directory -Path build -Force | Out-Null
javac -proc:none -encoding UTF-8 -d build src/Account.java src/TestAccount.java
java -cp build TestAccount
```

The repository launcher is another way to build and run the program. This version was checked on Windows with JDK 21.

## Notes

Revised during portfolio preparation to validate state changes and protect the creation date.

- Uses double monetary values for the classroom exercise.
- Annual interest rate is limited to 0–100 percent.
- No database, authentication, or transaction ledger.

[Back to the project index](../../../README.md)
