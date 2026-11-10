# Five-operation Calculator

A two-input Swing calculator for five arithmetic operations. This is a maintained Java coursework project.

## Features

- Add, subtract, multiply, calculate a remainder, or raise a number to a power.
- Display results in a read-only field.
- Reject nonfinite inputs, remainder by zero, and nonfinite results.
- Clear the inputs and result together.

## Run

A JDK 8 or later is needed to compile. The maintained version was checked on JDK 21 on Windows. GUI programs need a desktop session.

From this project's folder in PowerShell:

```powershell
New-Item -ItemType Directory -Path build -Force | Out-Null
javac -proc:none -encoding UTF-8 -d build src/CalculatorApp.java
java -cp build CalculatorApp
```

On macOS or Linux:

```sh
mkdir -p build
javac -proc:none -encoding UTF-8 -d build src/CalculatorApp.java
java -cp build CalculatorApp
```

Enter two finite numbers, then click an operation. The ^ button raises the first number to the power of the second.

## Notes

This version checks inputs and results, rejects remainder by zero, and clears outdated output before each calculation.

- There is no division operation, expression parser, or saved history.
- Calculations use double arithmetic; rounding and underflow limitations remain.

[Back to the project index](../../../README.md)
