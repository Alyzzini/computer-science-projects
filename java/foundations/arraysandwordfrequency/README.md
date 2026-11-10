# Distinct Values and Word Frequency

Finds distinct integers in first-seen order and counts case-insensitive words in a paragraph.

## What it does

- Distinct values from ten integers
- First-seen output order
- Case-insensitive token counting
- Validated public helper methods and bounded console input

## Run

From this folder with a JDK installed, in PowerShell:

```powershell
New-Item -ItemType Directory -Path build -Force | Out-Null
javac -proc:none -encoding UTF-8 -d build src/myPackage/Assignment.java src/myPackage/ConsoleInput.java
java -cp build myPackage.Assignment
```

The repository launcher is another way to build and run the program. This version was checked on Windows with JDK 21.

## Notes

Revised during portfolio preparation to validate helper arguments and bound console input.

- Punctuation stays attached to words, so word and word, are different tokens.
- Paragraphs are one line, up to 100,000 characters.
- At most 1,000 search terms, each up to 1,000 characters.

[Back to the project index](../../../README.md)
