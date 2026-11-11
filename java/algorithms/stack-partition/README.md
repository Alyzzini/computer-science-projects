# Stack Partition by Sign

Partition a stack so its negative integers sit below its nonnegative integers. This is a revised coursework exercise using Java's `Stack`, `Queue`, and `LinkedList`; the included file is synthetic sample data.

## Example

The complete [sample file](splitStack.txt) is:

```text
3
3 -2 0 5 -4
1 2 3
-1 -2 -3
```

The first line declares three cases. Each following nonblank line is one stack, written from **bottom to top**. The program prints:

```text
[-4, -2, 5, 0, 3]
[3, 2, 1]
[-3, -2, -1]
```

For the first case, popping visits `-4, 5, 0, -2, 3`. Those values enter one queue for negatives and another for nonnegatives. Pushing the negative queue back first puts it below the nonnegative group. This also explains why the original order within each sign group is reversed.

## Implementation

Read [`splitStack` in Main.java](src/splitStackProgram/Main.java). It empties the supplied stack into the two queues, then rebuilds the same stack. The queues preserve the order in which values were popped. This makes the grouping logic explicit, at the cost of storage proportional to the stack size.

`main` handles the text format separately: it reads the declared case count, parses each stack, rejects missing or extra cases, and reports file-read errors.

## Time and memory

Let **n** be the number of integers in one stack. The partition method takes **O(n) time**: each value is popped, enqueued, dequeued, and pushed once. The linked queues perform these operations in constant time, and the emptied stack already has capacity for the n values being put back.

The two queues hold **O(n) additional entries** in total. This excludes the caller's existing stack, which also occupies O(n) space. The file wrapper additionally holds the current input line; if that line has **L characters**, its line/parsing storage is O(L). Cases are processed one at a time, rather than retaining every case.

## Run and input format

From the repository root with Python 3.9+ and JDK 17+:

```text
python tools/projects.py run algorithms/stack-partition
```

The default file is `splitStack.txt`. Its first nonblank line is a nonnegative case count. Each declared case needs a nonblank line containing one or more signed 32-bit integers. Blank lines are ignored, and extra data after the declared cases is rejected.

To use `custom-input.txt` saved in this project folder:

```text
python tools/projects.py run algorithms/stack-partition -- custom-input.txt
```

## Limits

- Values are grouped by sign, not sorted numerically. Zero belongs to the nonnegative group.
- The file format cannot represent an empty stack case because blank lines are skipped. A zero case count is allowed.
- A late file error can be reported after earlier results have printed; output is not rolled back.

[Algorithms overview](../README.md) · [All projects](../../../README.md)
