# BMI Calculator

A small dialog-based exercise in numeric input, arithmetic, and conditional categories. This is a maintained Java coursework project.

## Features

- Read weight in kilograms and height in meters.
- Calculate BMI and show a two-decimal result with the exercise's category.
- Reject nonpositive, nonfinite, malformed, and out-of-range calculations.
- Allow cancellation at either input prompt.

## Run

A JDK 8 or later is needed to compile. The maintained version was checked on JDK 21 on Windows. GUI programs need a desktop session.

From this project's folder in PowerShell:

```powershell
New-Item -ItemType Directory -Path build -Force | Out-Null
javac -proc:none -encoding UTF-8 -d build src/BodyMassIndex.java
java -cp build BodyMassIndex
```

On macOS or Linux:

```sh
mkdir -p build
javac -proc:none -encoding UTF-8 -d build src/BodyMassIndex.java
java -cp build BodyMassIndex
```

Enter weight in kilograms and height in meters when prompted.

## Notes

This version adds positive and finite-value checks, including arithmetic range checks, while keeping the original formula and category thresholds.

- An educational calculator, not a medical assessment tool.
- It does not account for age or individual circumstances, and stores no measurements.

[Back to the project index](../../../README.md)
