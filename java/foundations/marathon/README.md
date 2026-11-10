# Runner Rankings

Finds the fastest and second-fastest entries in a list of running times.

## What it does

- Linear scans for the first two ranked indices
- Stable tie ordering by original index
- Nonnegative time and array validation

## Run

From this folder with a JDK installed, in PowerShell:

```powershell
New-Item -ItemType Directory -Path build -Force | Out-Null
javac -proc:none -encoding UTF-8 -d build src/Marathon.java
java -cp build Marathon
```

The repository launcher is another way to build and run the program. This version was checked on Windows with JDK 21.

## Notes

The sample fixture matches MIT OpenCourseWare’s 6.092 Assignment 3.

Validation and explicit tie handling were added during portfolio preparation.

- Second place means a different participant; an equal time is allowed.
- The bundled names and times are a published teaching fixture.

The teaching fixture is credited in [ATTRIBUTION.md](ATTRIBUTION.md).

[Back to the project index](../../../README.md)
