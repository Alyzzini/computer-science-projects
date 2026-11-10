# Rectangle Calculator

A Swing calculator for a rectangle's area and perimeter. This is a maintained Java coursework project.

## Features

- Read length and width and calculate area and perimeter.
- Require positive finite dimensions and results.
- Keep result fields read-only and clear old results before a new calculation.
- Reset all fields with one button.

## Run

A JDK 8 or later is needed to compile. The maintained version was checked on JDK 21 on Windows. GUI programs need a desktop session.

From this project's folder in PowerShell:

```powershell
New-Item -ItemType Directory -Path build -Force | Out-Null
javac -proc:none -encoding UTF-8 -d build src/RectangleApp.java
java -cp build RectangleApp
```

On macOS or Linux:

```sh
mkdir -p build
javac -proc:none -encoding UTF-8 -d build src/RectangleApp.java
java -cp build RectangleApp
```

Enter positive length and width values in the same unit, then click Calculate. Reset clears the inputs and results.

## Notes

This version adds input and result-range checks, clears outdated results, and makes output fields read-only.

- No unit conversion, saved history, or adjustable layout.
- Calculations use Java double values and their normal rounding limits.

[Back to the project index](../../../README.md)
