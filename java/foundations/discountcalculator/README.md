# Quantity Discount Calculator

Calculates the discount and final price for packages priced at $99 each.

## What it does

- Quantity-based discount brackets
- Savings and final-total output
- Validated nonnegative integer quantities

## Run

From this folder with a JDK installed, in PowerShell:

```powershell
New-Item -ItemType Directory -Path build -Force | Out-Null
javac -proc:none -encoding UTF-8 -d build src/myPackage/ConsoleInput.java src/myPackage/DiscountCalculator.java
java -cp build myPackage.DiscountCalculator
```

The repository launcher is another way to build and run the program. This version was checked on Windows with JDK 21.

## Notes

Revised during portfolio preparation to reject malformed and out-of-range quantities.

- Fixed classroom price and discount schedule.
- Uses double arithmetic and accepts quantities through Integer.MAX_VALUE.

[Back to the project index](../../../README.md)
