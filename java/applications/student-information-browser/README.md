# Student Information Browser

A Swing browser for a small collection of student records, with separate model, window, and application-entry classes. This is a maintained Java coursework project.

## Features

- Display six read-only fields for each record.
- Move through records with First, Previous, Next, and Last.
- Show the current record position and disable buttons at the ends of the collection.
- Use immutable Student objects and initialize the interface on Swing's event-dispatch thread.

## Run

A JDK 8 or later is needed to compile. The maintained version was checked on JDK 21 on Windows. GUI programs need a desktop session.

From this project's folder in PowerShell:

```powershell
New-Item -ItemType Directory -Path build -Force | Out-Null
javac -proc:none -encoding UTF-8 -d build src/Student.java src/StudentInformationApp.java src/StudentInformationFrame.java
java -cp build StudentInformationApp
```

On macOS or Linux:

```sh
mkdir -p build
javac -proc:none -encoding UTF-8 -d build src/Student.java src/StudentInformationApp.java src/StudentInformationFrame.java
java -cp build StudentInformationApp
```

Use the navigation buttons to browse the four fictional student records.

## Notes

This maintained version uses fictional names and IDs with example.invalid email addresses, and adds defensive checks for empty collections and invalid record indexes.

- The four records are defined in the source.
- There is no add, edit, delete, search, or storage feature.

[Back to the project index](../../../README.md)
