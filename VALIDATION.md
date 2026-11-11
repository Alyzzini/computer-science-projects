# Validation notes

## Included example checks

Run the five console examples from the repository root with Python 3.9+ and JDK 17+:

```sh
python tools/check_examples.py
```

Or select a JDK explicitly:

```sh
python tools/check_examples.py --java-home PATH_TO_JDK
```

The checker builds through the repository launcher, runs the actual programs, and compares their output with expected results. It covers stack partitioning, delimiter validation, unique course names, regional vote counting, and a synthetic phone-directory add/lookup/update/remove workflow. Sample files are read without modification. Each example has a 45-second limit, and a failed check makes the command return a nonzero exit status.

All five examples passed on November 10, 2026. A deliberately changed course fixture in a temporary copy correctly failed the unique-courses check. These are small reproducible examples; the broader recorded checks below cover additional cases.

The screenshots in `docs/screenshots/` are captures of real Swing components with synthetic input. The restaurant capture shows a $12.84 order, $20.00 payment, and $7.16 change; the student capture shows record 2 of 4. Their displayed states were checked before capture. The phone-directory transcript is actual process output.

## Broader recorded checks

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

Use `python tools/projects.py list` to see program IDs, then run a selected project with `python tools/projects.py run ID`. The broader local regression harnesses and raw audit logs are not bundled in this repository. The five included console checks are available in `tools/check_examples.py`; compilation alone does not repeat those checks or the broader runtime scenarios.

## Limits

- Passing these cases does not establish correct behavior for every possible input or environment.
- GUI interaction was programmatic. Full manual keyboard, accessibility, alternate display scaling, macOS and Linux walkthroughs were not performed.
- The car and clothing interfaces scale illustrations into fixed image boxes; aspect ratio is not preserved in those displays.
- MARIE source was checked in a custom instruction model, not an official simulator GUI. Simulator-specific input parsing and display modes remain unverified.
- These are current checks of maintained source and reference exercises, not historical course grades or performance benchmarks.

[Back to all projects](README.md)
