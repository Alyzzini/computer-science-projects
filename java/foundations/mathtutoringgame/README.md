# Math Tutoring Game

An interactive arithmetic exercise with random addition, subtraction, and multiplication questions.

## What it does

- Operands from 10 through 50
- Correct and incorrect answer feedback
- Menu loop with an exit option
- Malformed-answer retries retain the current question

## Run

From this folder with a JDK installed, in PowerShell:

```powershell
New-Item -ItemType Directory -Path build -Force | Out-Null
javac -proc:none -encoding UTF-8 -d build src/myPackage/ConsoleInput.java src/myPackage/MathTutoringProject.java
java -cp build myPackage.MathTutoringProject
```

The repository launcher is another way to build and run the program. This version was checked on Windows with JDK 21.

## Notes

This maintained version replaces the original arithmetic practice submission.

Input handling and numeric bounds were revised during portfolio preparation.

- No score history or persistence.
- Questions use Math.random and are not seeded by the application.

[Back to the project index](../../../README.md)
