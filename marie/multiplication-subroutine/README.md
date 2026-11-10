# MARIE Multiplication Subroutine

Performs bounded multiplication through a MARIE subroutine.

## What it does

- JnS call and JumpI return
- Result passed through Product
- Repeated-addition loop with overflow checks

## Use

Open the `.mas` source under `src/` in a classic MARIE environment. Supply decimal integer inputs from 0 through 32767; -1 is the error result. The assembly was checked in a custom instruction model, not through an official simulator interface.

## Notes

Revised during portfolio preparation to correct Skipcond branch structure and add input-domain and overflow checks.

- Inputs must be integers from 0 through 32767.
- Product is −1 for negative inputs or overflow.
- Input parsing outside the signed 16-bit word range belongs to the simulator.
- Verified with a documented custom instruction model; official GUI compatibility was not tested.

[Back to the project index](../../README.md)
