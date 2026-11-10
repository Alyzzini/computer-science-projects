# Cache mapping practice

A worked reference exercise added during portfolio preparation. It uses a small synthetic address sequence to show how tags, indexes, and offsets determine hits and misses.

## Setup
A byte-addressed system uses 16-bit addresses and an initially empty direct-mapped cache. The cache holds 64 bytes in four lines of 16 bytes each. For addresses 0x0000, 0x0004, 0x0040, 0x0000, 0x0010, 0x0050, 0x0054, identify tag/index/offset and hit/miss. Ignore writes and replacement policies beyond direct mapping.

## Worked solution
Offset = log2(16) = 4 bits. Index = log2(4) = 2 bits. Tag = 16 − 4 − 2 = 10 bits. Block number = floor(address/16), index = block mod 4, tag = floor(block/4).

| Address | Block | Tag | Index | Offset | Result and reason |
|---|---:|---:|---:|---:|---|
| 0x0000 | 0 | 0 | 0 | 0 | Miss, fill empty line 0 |
| 0x0004 | 0 | 0 | 0 | 4 | Hit, same block |
| 0x0040 | 4 | 1 | 0 | 0 | Miss, replace line 0 |
| 0x0000 | 0 | 0 | 0 | 0 | Miss, tag 1 is present; replace with tag 0 |
| 0x0010 | 1 | 0 | 1 | 0 | Miss, fill empty line 1 |
| 0x0050 | 5 | 1 | 1 | 0 | Miss, replace line 1 |
| 0x0054 | 5 | 1 | 1 | 4 | Hit, same block |

The sequence has 2 hits and 5 misses, so the hit fraction is 2/7, approximately 28.57%. This is a worked synthetic example, not a measured hardware benchmark or a recovered course answer.

## Self-check
At the end line 0 has tag 0, line 1 has tag 1, and lines 2–3 remain invalid. Address 0x005F would hit line 1; 0x0090 would miss there and replace tag 1 with tag 2.

[Back to the project index](../../README.md)
