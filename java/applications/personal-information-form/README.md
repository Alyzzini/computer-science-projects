# Personal Information Form

A Swing form exercise that checks input and displays a local summary. This is a maintained Java coursework project.

## Features

- Enter a name, street, city, state, phone number, and email address.
- Choose an optional gender value from the original form's two radio buttons.
- Check required text, a state selection, ten-digit phone syntax, and a basic email pattern.
- Clear every field and radio selection, or show a summary dialog.

## Run

A JDK 8 or later is needed to compile. The maintained version was checked on JDK 21 on Windows. GUI programs need a desktop session.

From this project's folder in PowerShell:

```powershell
New-Item -ItemType Directory -Path build -Force | Out-Null
javac -proc:none -encoding UTF-8 -d build src/PersonalInformationApp.java
java -cp build PersonalInformationApp
```

On macOS or Linux:

```sh
mkdir -p build
javac -proc:none -encoding UTF-8 -d build src/PersonalInformationApp.java
java -cp build PersonalInformationApp
```

Use fictional details when trying the form. Submit displays the information in a local dialog; Clear resets it.

## Notes

This version adds input checks, fixes clearing grouped radio buttons, and widens the form so ordinary street and email entries fit.

- Only nine states and the original two gender choices are listed.
- Email and phone checks validate syntax, not ownership or deliverability.
- The form does not save, send, or encrypt data, and is not an account-registration system.

[Back to the project index](../../../README.md)
