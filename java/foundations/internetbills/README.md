# Internet Bill Calculator

Calculates a monthly bill for one of three fixed service plans.

## What it does

- Exact A, B, or C plan selection
- Base fees and extra-hour charges
- Fractional-hour support
- Validated usage and input retries

## Run

From this folder with a JDK installed, in PowerShell:

```powershell
New-Item -ItemType Directory -Path build -Force | Out-Null
javac -proc:none -encoding UTF-8 -d build src/myPackage/ConsoleInput.java src/myPackage/InternetBills.java
java -cp build myPackage.InternetBills
```

The repository launcher is another way to build and run the program. This version was checked on Windows with JDK 21.

## Notes

Revised during portfolio preparation to validate complete plan names and bound usage.

- Usage is limited to 0–744 hours, an explicit 31-day practice assumption.
- Prices are exercise constants, not current commercial offers.

[Back to the project index](../../../README.md)
