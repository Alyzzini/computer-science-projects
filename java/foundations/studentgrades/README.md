# Grade Calculator

Averages three scores and assigns a letter grade using fixed score thresholds.

## What it does

- Three scores in the 0–100 range
- Average displayed to two decimal places
- A–F grade selection
- Input retries and clean end-of-input handling

## Run

From this folder with a JDK installed, in PowerShell:

```powershell
New-Item -ItemType Directory -Path build -Force | Out-Null
javac -proc:none -encoding UTF-8 -d build src/myPackage/ConsoleInput.java src/myPackage/StudentGrades.java
java -cp build myPackage.StudentGrades
```

The repository launcher is another way to build and run the program. This version was checked on Windows with JDK 21.

## Notes

Revised during portfolio preparation to validate every score and handle incomplete input.

- Three equally weighted scores and fixed thresholds.
- No student roster or grade persistence.

[Back to the project index](../../../README.md)
