# BMI Calculator

Converts pounds and inches to a BMI value and displays the exercise’s conditional result message.

## What it does

- Pounds-to-kilograms and inches-to-meters conversion
- Validated positive finite input
- Numeric range checks and clean end-of-input handling

## Run

From this folder with a JDK installed, in PowerShell:

```powershell
New-Item -ItemType Directory -Path build -Force | Out-Null
javac -proc:none -encoding UTF-8 -d build src/myPackage/BMI.java src/myPackage/ConsoleInput.java
java -cp build myPackage.BMI
```

The repository launcher is another way to build and run the program. This version was checked on Windows with JDK 21.

## Notes

Revised during portfolio preparation to handle invalid input and numeric extremes.

- Uses the exercise’s original messages and thresholds; it is an educational calculation.
- Input values must produce a finite, positive result.

[Back to the project index](../../../README.md)
