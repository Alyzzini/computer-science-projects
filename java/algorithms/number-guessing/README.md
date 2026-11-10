# Number Guessing Game

A console guessing game with a random target from 0 through 100 and high-or-low hints.

A revised version of a Java coursework exercise.

## What it does

- Keeps accepting guesses until the target is found.
- Gives higher/lower feedback after valid guesses.
- Reprompts after invalid input and stops cleanly when input ends.

## Run

Use a JDK with `javac` and `java` on your command path. These commands are run from the project folder; create `build` only if it does not already exist.

```text
mkdir build
javac -proc:none -encoding UTF-8 -d build src/Program4_Guess.java
java -cp build Program4_Guess
```

Enter guesses between 0 and 100 and narrow the range using the hints. A correct guess ends the game.

## Notes

- The target changes between runs.
- There is no score history or saved game state.

## Checks

The current version passed 4 recorded runtime scenarios on Temurin JDK 21 for Windows. The checks covered normal inputs and relevant error or boundary cases. This does not guarantee behavior for every input or platform.

[Back to the project index](../../../README.md)
