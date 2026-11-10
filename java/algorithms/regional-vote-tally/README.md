# Regional Vote Tally

Counts candidate tokens for several regions and reports a winner only when a candidate has a strict majority.

A revised version of a Java coursework exercise. The included candidate names and ballots are fictional sample data.

## What it does

- Uses a HashMap to count votes for each candidate.
- Distinguishes a strict majority from a tie or a plurality without a majority.
- Handles zero-vote regions and checks declared counts.
- Reports malformed, missing, extra, or unreadable input.

## Run

Use a JDK with `javac` and `java` on your command path. These commands are run from the project folder; create `build` only if it does not already exist.

```text
mkdir build
javac -proc:none -encoding UTF-8 -d build src/Program2.java
java -cp build Program2
```

In the included four-region file, CandidateA wins the first region. The tie, zero-vote, and plurality-only regions each produce a runoff message.

## Input file

`election.txt` is included as sample data. Whitespace-separated UTF-8 tokens: a nonnegative region count, then for each region a nonnegative vote count followed by exactly that many single-token candidate names. No extra tokens follow the declared regions.

The default file is read from the working directory. To use another file, pass its path after the class name:

```text
java -cp build Program2 path/to/input.txt
```

## Notes

- Candidate names are single case-sensitive tokens.
- A region needs more than half its votes for a winner; zero votes produce the runoff message.
- A late file error may be reported after earlier region results have already printed.
- This is a counting exercise with fictional ballots, not an election system.

## Checks

The current version passed 26 recorded runtime scenarios on Temurin JDK 21 for Windows. The checks covered normal inputs and relevant error or boundary cases. This does not guarantee behavior for every input or platform.

[Back to the project index](../../../README.md)
