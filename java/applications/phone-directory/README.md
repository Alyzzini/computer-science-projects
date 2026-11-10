# Phone Directory

A console phone directory built around an ArrayList of member records. This is a maintained Java coursework project.

## Features

- Add, find, update, remove, and list contacts.
- Match names without case differences and reject duplicate names.
- Format ten-digit phone numbers, filter by a three-digit area code, and sort by last name.
- Start with twenty fictional contacts and handle the end of console input.

## Run

A JDK 8 or later is needed to compile. The maintained version was checked on JDK 21 on Windows. GUI programs need a desktop session.

From this project's folder in PowerShell:

```powershell
New-Item -ItemType Directory -Path build -Force | Out-Null
javac -proc:none -encoding UTF-8 -d build src/PhoneDirectory.java
java -cp build PhoneDirectory
```

On macOS or Linux:

```sh
mkdir -p build
javac -proc:none -encoding UTF-8 -d build src/PhoneDirectory.java
java -cp build PhoneDirectory
```

Choose an option from the numbered menu. Changes last until the program closes.

## Notes

This maintained version adds blank-name and phone-input checks, normalizes name spacing, and handles closed input. The bundled contacts are fictional examples.

- Records stay in memory; there is no file storage or database.
- Phone checks cover input format, not whether a number exists.
- Last-name sorting uses the last word in each name and a simple quadratic sort.

[Back to the project index](../../../README.md)
