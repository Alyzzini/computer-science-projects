# Search and Sort Reference

A reference exercise implementing insertion sort, merge sort, and first-match binary search.

## What it does

- Sorts return new arrays and preserve input
- Duplicate values retained
- Binary search returns the first matching index
- Null argument validation

## Run

From this folder with a JDK installed, in PowerShell:

```powershell
New-Item -ItemType Directory -Path build -Force | Out-Null
javac -proc:none -encoding UTF-8 -d build src/SearchSortPractice.java
java -cp build SearchSortPractice
```

The repository launcher is another way to build and run the program. This version was checked on Windows with JDK 21.

## Notes

Reference exercise added during portfolio preparation on November 10, 2026.

- Binary search requires ascending input.
- Insertion sort has quadratic worst-case time.
- The sort methods allocate copies and merge sort also uses a temporary buffer.

[Back to the project index](../../README.md)
