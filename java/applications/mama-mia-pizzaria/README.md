# Mama Mia Pizzaria

A dialog-based pizza order calculator. This is a maintained Java coursework project.

## Features

- Choose a small, medium, or large pizza.
- Add pepperoni, mushrooms, and extra cheese through yes/no prompts.
- Show a complete selection summary and total using integer cents.
- Cancel from the size prompt or by closing any topping prompt.

## Run

A JDK 8 or later is needed to compile. The maintained version was checked on JDK 21 on Windows. GUI programs need a desktop session.

From this project's folder in PowerShell:

```powershell
New-Item -ItemType Directory -Path build -Force | Out-Null
javac -proc:none -encoding UTF-8 -d build src/MamaMiaPizzaria.java
java -cp build MamaMiaPizzaria
```

On macOS or Linux:

```sh
mkdir -p build
javac -proc:none -encoding UTF-8 -d build src/MamaMiaPizzaria.java
java -cp build MamaMiaPizzaria
```

Run the program and follow the dialogs. A final dialog shows the selected size, toppings, and price.

## Notes

This version uses integer cents for prices and treats a closed topping dialog as cancellation.

- One pizza per run, with no tax, payment, or saved orders.

[Back to the project index](../../../README.md)
