# Stack Partition by Sign

Reads integer stacks from a text file and places negative integers below nonnegative integers using two queues.

A revised version of a Java coursework exercise. The included text file is a new sample input.

## What it does

- Uses Stack, Queue, and LinkedList from the Java standard library.
- Processes multiple stack cases from a UTF-8 input file.
- Checks case counts, malformed integers, missing or extra data, and file-read failures.

## Run

Use a JDK with `javac` and `java` on your command path. These commands are run from the project folder; create `build` only if it does not already exist.

```text
mkdir build
javac -proc:none -encoding UTF-8 -d build src/splitStackProgram/Main.java
java -cp build splitStackProgram.Main
```

The sample stack 3 -2 0 5 -4 becomes [-4, -2, 5, 0, 3].

## Input file

`splitStack.txt` is included as sample data. The first nonblank line is a nonnegative case count. Each following nonblank line contains one or more signed 32-bit integers for one stack, listed bottom to top. No extra data follows the declared cases.

The default file is read from the working directory. To use another file, pass its path after the class name:

```text
java -cp build splitStackProgram.Main path/to/input.txt
```

## Notes

- This partitions by sign rather than sorting by value.
- The input lists each stack from bottom to top. Popping the original stack reverses order within each sign group.
- Blank lines are ignored; each declared case needs at least one integer.
- A late file error may be reported after earlier case results have already printed.

## Checks

The current version passed 21 recorded runtime scenarios on Temurin JDK 21 for Windows. The checks covered normal inputs and relevant error or boundary cases. This does not guarantee behavior for every input or platform.

[Back to the project index](../../../README.md)
