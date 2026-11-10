# MARIE Conditional Arithmetic

Computes Z + max(X, Y) with conditional branches in MARIE.

## What it does

- Three signed-word inputs
- Explicit comparison branches
- Pre-addition overflow detection

## Use

Open the `.mas` source under `src/` in a classic MARIE environment. Supply decimal integer inputs from 0 through 32767; -1 is the error result. The assembly was checked in a custom instruction model, not through an official simulator interface.

## Notes

Revised during portfolio preparation to correct Skipcond branch structure and add input-domain and overflow checks.

- Inputs must be integers from 0 through 32767.
- Negative inputs or an overflowing result produce −1.
- Input parsing outside the signed 16-bit word range belongs to the simulator.
- Verified with a documented custom instruction model; official GUI compatibility was not tested.

[Back to the project index](../../README.md)
