# File-Backed Task List

A console reference exercise for managing tasks stored in a UTF-8 text file.

## What it does

- List, add, complete, and remove tasks
- Tab-separated records with stable IDs during a session
- Validation of malformed files and duplicate IDs
- Temporary-file saves with rollback of in-memory edits after failure

## Run

From this folder with a JDK installed, in PowerShell:

```powershell
New-Item -ItemType Directory -Path build -Force | Out-Null
javac -proc:none -encoding UTF-8 -d build src/TaskList.java
java -cp build TaskList
```

The repository launcher is another way to build and run the program. This version was checked on Windows with JDK 21.

The default file is `tasks.tsv`. To keep the sample unchanged, launch with a separate filename: `java -cp build TaskList my-tasks.tsv`.

## Notes

Reference exercise added during portfolio preparation on November 10, 2026.

The included task data is synthetic.

- One process should edit the file at a time.
- Deleted highest IDs may be reused after a restart.
- Uses atomic replacement where supported and a normal replacement fallback otherwise.

[Back to the project index](../../README.md)
