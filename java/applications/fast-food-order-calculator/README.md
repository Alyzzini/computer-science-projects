# Fast Food Order Calculator

A Swing order calculator with sandwich choices, optional sides and drinks, an order summary, and change calculation. This is a maintained Java coursework project.

## Features

- Choose one of four sandwiches and add sides, drinks, or desserts.
- Update the item summary, subtotal, tax, and total when selections change.
- Calculate 7% tax using integer cents and half-up rounding.
- Check payment format and sufficient payment before showing change; reset the order with one button.

## Run

A JDK 8 or later is needed to compile. The maintained version was checked on JDK 21 on Windows. GUI programs need a desktop session.

From this project's folder in PowerShell:

```powershell
New-Item -ItemType Directory -Path build -Force | Out-Null
javac -proc:none -encoding UTF-8 -d build src/FastFoodRestaurant.java
java -cp "build;resources" FastFoodRestaurant
```

On macOS or Linux:

```sh
mkdir -p build
javac -proc:none -encoding UTF-8 -d build src/FastFoodRestaurant.java
java -cp "build:resources" FastFoodRestaurant
```

Make menu selections, enter the amount paid, and click Total to calculate change. The subtotal, tax, and total update as selections change.

## Notes

The original selection summary updated automatically, while monetary totals required the Total button. This version also updates monetary totals on selection changes, checks payment, clears outdated change, and uses integer cents.

The four menu images are generic illustrations supplied in place of missing image files. They are placeholders, not product photographs.

- One fixed-price order at a time; there are no item quantities, saved orders, or inventory.
- This is a calculator, with no payment processing.
- The tax rate is fixed at 7%; payments must be no more than $1,000,000 and have at most two decimal places.

[Back to the project index](../../../README.md)
