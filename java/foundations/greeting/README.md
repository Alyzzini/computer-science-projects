# Console Greeting

A short console program that prints a greeting and a synthetic profile.

## What it does

- Formatted console output
- Synthetic profile values

## Run

From this folder with a JDK installed, in PowerShell:

```powershell
New-Item -ItemType Directory -Path build -Force | Out-Null
javac -proc:none -encoding UTF-8 -d build src/Greeting.java
java -cp build Greeting
```

The repository launcher is another way to build and run the program. This version was checked on Windows with JDK 21.

## Notes

Reconstructed from the visible behavior of earlier greeting exercises during portfolio preparation.

The profile is synthetic; this is newly prepared source rather than a recovered source file.

- A small setup exercise with no user input or saved state.

[Back to the project index](../../../README.md)
