# Sorted Unique Courses

Read course records and print each distinct course name in sorted order. A `TreeSet` handles both duplicate removal and ordering. This is a revised coursework exercise; the sample student identifiers are fictional.

## Example

The complete [sample file](classes.txt) is:

```text
DEMO001 Math
DEMO002 Science
DEMO003 History
DEMO004 Math
DEMO005 Science
```

The program prints:

```text
[History, Math, Science]
```

Repeated `Math` and `Science` records contribute only one entry each. The order comes from the set, not the order of the input records.

## Implementation

[`Program1.java`](src/Program1.java) reads one line at a time with a UTF-8 `BufferedReader`. It skips blank lines, splits each remaining line on whitespace, and adds the second token to a `TreeSet<String>`. Rows without that token produce a line-numbered error.

Using an ordered set avoids collecting every record and sorting a separate result afterward. The tradeoff is comparison work on each insertion. Only distinct course names remain in the set; identifiers are not retained.

## Time and memory

Let **n** be the number of nonblank records and **k** the number of distinct course names. Set insertion takes **O(n log(k + 1)) string comparisons** overall. This statement counts comparisons rather than treating arbitrarily long names as free.

If **B** is the number of characters read and **L** the longest course name, a character-cost bound is **O(B + n L log(k + 1))**, including parsing. Printing the result also visits the stored name characters, which are already bounded by B.

The set holds **O(k) entries plus the characters in the k distinct names**. The reader and split operation also need storage for the current line and its tokens: O(M), where **M** is the longest line length. Even ignored extra fields are temporarily parsed by `split`. The program does not keep all input records in memory.

## Run and input format

From the repository root with Python 3.9+ and JDK 17+:

```text
python tools/projects.py run algorithms/unique-courses
```

The default file is `classes.txt`. Each nonblank UTF-8 line needs an identifier and a single-token course name separated by whitespace. To use `custom-input.txt` saved in this project folder:

```text
python tools/projects.py run algorithms/unique-courses -- custom-input.txt
```

## Limits

- Names are case-sensitive and use Java's natural string order. `Math` and `math` are distinct.
- Only the second token is collected; later fields are ignored. A multiword course name is therefore not supported.
- An empty file prints `[]`. Malformed rows or unreadable input produce an error rather than a course list.
- This lists course names; it does not manage enrollment.

[Algorithms overview](../README.md) · [All projects](../../../README.md)
