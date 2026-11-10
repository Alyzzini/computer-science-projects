# Car Inventory Lookup

A Swing vehicle lookup exercise using a HashMap of sample car records. This is a maintained Java coursework project.

## Features

- Search an exact vehicle ID and display its make, model, year, and price.
- Show clear found/not-found feedback.
- Load an illustration after a successful search.
- Clear old results when the ID changes and report missing images.

## Run

A JDK 8 or later is needed to compile. The maintained version was checked on JDK 21 on Windows. GUI programs need a desktop session.

From this project's folder in PowerShell:

```powershell
New-Item -ItemType Directory -Path build -Force | Out-Null
javac -proc:none -encoding UTF-8 -d build src/CarInventoryApp.java
java -cp "build;resources" CarInventoryApp
```

On macOS or Linux:

```sh
mkdir -p build
javac -proc:none -encoding UTF-8 -d build src/CarInventoryApp.java
java -cp "build:resources" CarInventoryApp
```

Enter a sample ID from 1001 through 1010 and click Search. Click Show Picture to display its illustration.

## Notes

This version loads bundled resources from the classpath and clears previous results when the search text changes. Generic illustrations replace the missing image files.

The illustrations depict a generic car, not the named vehicle models. Brand and model names are sample record text; the project is not affiliated with a manufacturer.

- The ten sample records are fixed; there are no inventory edits or database connections.
- Prices and model years are exercise data, not current offers.
- The window uses a fixed layout.

[Back to the project index](../../../README.md)
