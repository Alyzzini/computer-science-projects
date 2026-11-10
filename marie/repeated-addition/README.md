# MARIE Repeated-Addition Multiplication

Multiplies two nonnegative integers through a repeated-addition loop.

## What it does

- Uses the smaller operand as the loop count
- Handles zero operands
- Checks each addition before overflow

## Use

Open the `.mas` source under `src/` in a classic MARIE environment. Supply decimal integer inputs from 0 through 32767; -1 is the error result. The assembly was checked in a custom instruction model, not through an official simulator interface.

## Notes

Revised during portfolio preparation to correct Skipcond branch structure and add input-domain and overflow checks.

- Inputs must be integers from 0 through 32767.
- Negative inputs or an overflowing product produce −1.
- Input parsing outside the signed 16-bit word range belongs to the simulator.
- Verified with a documented custom instruction model; official GUI compatibility was not tested.

[Back to the project index](../../README.md)
