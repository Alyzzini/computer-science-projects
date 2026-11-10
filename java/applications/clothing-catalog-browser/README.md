# Clothing Catalog Browser

A Swing catalog browser for four clothing records stored in a two-dimensional array. This is a maintained Java coursework project.

## Features

- Display each item's ID, name, size, price, and illustration.
- Browse using First, Previous, Next, and Last.
- Show a message when navigation reaches a boundary.
- Keep displayed values read-only and handle missing images.

## Run

A JDK 8 or later is needed to compile. The maintained version was checked on JDK 21 on Windows. GUI programs need a desktop session.

From this project's folder in PowerShell:

```powershell
New-Item -ItemType Directory -Path build -Force | Out-Null
javac -proc:none -encoding UTF-8 -d build src/ClothingStore.java
java -cp "build;resources" ClothingStore
```

On macOS or Linux:

```sh
mkdir -p build
javac -proc:none -encoding UTF-8 -d build src/ClothingStore.java
java -cp "build:resources" ClothingStore
```

Use the navigation buttons to move between the four sample items.

## Notes

This version corrects the previous/next labels, makes fields read-only, improves button spacing, and loads bundled placeholder images from the classpath.

The images are generic illustrations supplied in place of missing product images. They are not photographs of the named products.

- This is a fixed sample catalog with no cart, stock tracking, editing, or persistence.
- Prices and sizes are exercise data.
- The window uses a fixed layout.

[Back to the project index](../../../README.md)
