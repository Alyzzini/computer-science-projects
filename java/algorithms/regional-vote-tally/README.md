# Regional Vote Tally

Count candidate-name tokens for each region and report a winner only when one candidate has more than half the votes. This revised coursework exercise uses a `HashMap` and fictional sample ballots.

## Example

The complete [sample file](election.txt) is:

```text
4
5
CandidateA CandidateB CandidateA CandidateA CandidateC
4
CandidateA CandidateB CandidateA CandidateB
0
5
CandidateA CandidateA CandidateB CandidateB CandidateC
```

The program prints:

```text
CandidateA won the election.

Nobody won! A special runoff election will be held.

Nobody won! A special runoff election will be held.

Nobody won! A special runoff election will be held.
```

The first region gives CandidateA 3 of 5 votes. The remaining regions demonstrate a 2-2 tie, zero votes, and a 2-2-1 split. A largest count alone is insufficient: a winner must have a strict majority.

## Implementation

[`Program2.java`](src/Program2.java) creates a new `HashMap<String, Integer>` for each region. Every ballot increments its candidate's count with `getOrDefault`. A second pass through the map finds the largest count, and `maxVotes > votes / 2` applies the majority rule.

The map stores counts rather than a list of every ballot. Its iteration order does not determine the outcome: a strict majority can belong to at most one candidate, and tied largest counts produce the runoff message.

## Time and memory

For one region, let **v** be its vote count and **c** its number of distinct candidate names. Counting is **expected O(v)** under the usual constant-time hash-table assumption. Scanning the counts adds **O(c)**, giving **expected O(v + c)** map work per region. This is not an unconditional worst-case linear guarantee: string hashing/equality adds work for name characters, and collisions can increase lookup cost.

The map uses **O(c) entries plus the characters in the c stored names**. `Scanner` and the current token add input-buffer memory. Votes are processed as tokens rather than retained in a ballot array. The live count data is for the current region; maps are not accumulated across regions. The time across a file is the sum of its per-region work plus reading its input characters.

## Run and input format

From the repository root with Python 3.9+ and JDK 17+:

```text
python tools/projects.py run algorithms/regional-vote-tally
```

The default file is `election.txt`. Its whitespace-separated UTF-8 tokens are a nonnegative region count, then for each region a nonnegative vote count followed by exactly that many candidate names. Extra tokens after the declared regions are rejected.

To use `custom-input.txt` saved in this project folder:

```text
python tools/projects.py run algorithms/regional-vote-tally -- custom-input.txt
```

## Limits

- Candidate names are single case-sensitive tokens.
- Exactly half the votes is insufficient. A zero-vote region produces the runoff message.
- Negative, malformed, missing, extra, or unreadable input is reported as an error. Earlier region results can already have printed before a late error.
- This is a counting exercise, not an election system: it has no voter identity checks, duplicate-ballot detection, persistence, or election security features.

[Algorithms overview](../README.md) · [All projects](../../../README.md)
