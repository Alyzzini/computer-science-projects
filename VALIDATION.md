# Validation notes

The prepared source package was checked on November 10, 2026 using Temurin JDK 21 on Windows. Java compilation targets Java 8 language and API compatibility; Java 8 itself was not used for execution.

| Group | Programs | Passed runtime scenarios |
| --- | ---: | ---: |
| Applications | 10 | 123 |
| Algorithms and data structures | 12 | 170 |
| Foundations | 9 | 121 |
| Java reference exercises | 2 | 20 |
| Total Java | 33 | 434 |

The Foundations suite separately records nine fresh compilation checks. They are not counted in the 434 runtime scenarios. The three MARIE programs passed 47 named checks covering 11,021 assembled-program executions in a custom classic-MARIE model, with 34 separate checks of the model.

The checks covered ordinary inputs, numeric boundaries, invalid or exhausted input, file formats, collection operations, persistence and failed-save rollback where relevant. Swing checks exercised real controls, dialogs, startup and shutdown. All 18 PNG resources loaded through the graphical interfaces, and the new restaurant, car and clothing renders were inspected.

The repository's build/run launcher passed 37 integration checks, including argument forwarding, resource loading, invalid project IDs, failed compilation, JDK selection, and redirected build paths. The published 33-project registry was checked and all 33 projects were compiled through this launcher.

## Repeat a build

```sh
python tools/projects.py build all
```

Use `python tools/projects.py list` to see program IDs, then run a selected project with `python tools/projects.py run ID`. The local regression harnesses and raw audit logs are not bundled in this repository. Compilation alone does not repeat the runtime checks above.

## Limits

- Passing these cases does not establish correct behavior for every possible input or environment.
- GUI interaction was programmatic. Full manual keyboard, accessibility, alternate display scaling, macOS and Linux walkthroughs were not performed.
- The car and clothing interfaces scale illustrations into fixed image boxes; aspect ratio is not preserved in those displays.
- MARIE source was checked in a custom instruction model, not an official simulator GUI. Simulator-specific input parsing and display modes remain unverified.
- These are current checks of maintained source and reference exercises, not historical course grades or performance benchmarks.

[Back to all projects](README.md)
