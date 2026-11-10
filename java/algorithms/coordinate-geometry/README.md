# Coordinate Geometry Calculator

Calculates the slope and distance between two points with integer coordinates.

A revised version of a Java coursework exercise.

## What it does

- Provides separate slope and distance methods.
- Reports undefined slope for vertical lines or identical points.
- Uses long coordinate differences and Math.hypot to handle signed integer extremes.

## Run

Use a JDK with `javac` and `java` on your command path. These commands are run from the project folder; create `build` only if it does not already exist.

```text
mkdir build
javac -proc:none -encoding UTF-8 -d build src/Program1.java
java -cp build Program1
```

For (5, 2) and (7, 6), the slope is 2.0 and the distance is approximately 4.472135955.

## Notes

- Coordinates must be signed 32-bit integers.
- Distance and slope are floating-point approximations.

## Checks

The current version passed 13 recorded runtime scenarios on Temurin JDK 21 for Windows. The checks covered normal inputs and relevant error or boundary cases. This does not guarantee behavior for every input or platform.

[Back to the project index](../../../README.md)
