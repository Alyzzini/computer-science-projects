# Java algorithms and data structures

Four small programs show how stacks, queues, sets, and maps solve different problems. Each reads a text file and has a short input/output example in its README. They use Java's collection classes; the exercise code implements the processing logic around them.

| Exercise | Data structure | What to look for | Source |
| --- | --- | --- | --- |
| [Stack partition](stack-partition/) | Stack and two queues | Group values by sign while accounting for the order introduced by popping a stack | [Main.java](stack-partition/src/splitStackProgram/Main.java) |
| [Delimiter validation](delimiter-validation/) | Stack | Match the most recent opening delimiter and reject incorrect nesting | [Main.java](delimiter-validation/src/Main.java) |
| [Unique courses](unique-courses/) | TreeSet | Remove duplicates and maintain sorted order during insertion | [Program1.java](unique-courses/src/Program1.java) |
| [Regional vote tally](regional-vote-tally/) | HashMap | Count frequencies, then distinguish a strict majority from a plurality | [Program2.java](regional-vote-tally/src/Program2.java) |

From the repository root, run any example with Python 3.9+ and JDK 17+:

```text
python tools/projects.py run algorithms/stack-partition
python tools/projects.py run algorithms/delimiter-validation
python tools/projects.py run algorithms/unique-courses
python tools/projects.py run algorithms/regional-vote-tally
```

The launcher builds each program and uses its project folder as the working directory, so the included sample file is found automatically. The four READMEs explain input formats, implementation choices, complexity assumptions, and limits. These are revised coursework exercises with synthetic sample files.

## Other exercises

- [Coordinate geometry](coordinate-geometry/) — slope and distance, including vertical lines and integer-coordinate limits.
- [Relative grades](relative-grades/) — array input, a maximum search, and grade bands relative to the best score.
- [Number guessing](number-guessing/) — a loop with high/low feedback and input validation.
- [Lottery digit matching](lottery/) — digit extraction and conditional matching rules.
- [Gratuity calculator](gratuity/) — percentage arithmetic and formatted output.
- [Income-band tax](income-band-tax/) — conditional rate selection using a classroom formula, not current tax rules.
- [Bank account collection](bank-account-tester/) — object arrays, totals, filtering, and lookup. The missing `BankAccount` dependency was reconstructed from the tester interface; the sample identities are fictional.
- [Six recursive methods](recursive-methods/) — sequence and digit operations in a runnable wrapper reconstructed from written answers. The wrapper and input bounds were added for this version.

[All projects](../../README.md)
