# Phone Directory

A menu-driven Java program for keeping a small contact list: add a member, find or update a number, filter by area code, remove an entry, and sort by last name. This maintained coursework project starts with twenty fictional contacts.

## Run

From the repository root, with Python 3.9+ and JDK 17+ available:

```sh
python tools/projects.py run applications/phone-directory
```

The launcher builds the project before running it. See the [repository setup instructions](../../../README.md#try-a-project) to select a JDK explicitly.

## Try it

1. Choose `2` to add `Demo Rowan` with `(202) 555-0199`.
2. Choose `1` and search for `demo rowan`. The result is:

   ```text
   Demo Rowan  202-555-0199
   ```

3. Choose `3` to change that member's number to `3035550198`, then look it up again.
4. Choose `6` to remove the member. A later lookup reports that the member was not found.
5. Try `5` with area code `202`, or `7` to sort the directory. Choose `8` to exit.

The [captured console transcript](../../../docs/demos/phone-directory.txt) shows an actual add, lookup, update, and remove run using these fictional details.

## Design and tradeoffs

The implementation is in [PhoneDirectory.java](src/PhoneDirectory.java).

- **Collection and model:** an `ArrayList<Member>` holds name/number pairs. `findMember()` uses a case-insensitive linear search, so lookup is O(n). This keeps the exercise small, but a larger directory would benefit from an indexed lookup.
- **Input boundary:** `readName()` trims and normalizes spacing; `formatPhoneNumber()` checks allowed characters and formats ten digits. The menu catches malformed numeric choices, and closed input exits cleanly.
- **Sorting:** `sortByLastName()` swaps entries using a nested loop, giving O(n²) time. It treats the final word as the last name, which is simple but does not cover every naming convention.

## Scope and maintenance

Records exist only for the current run; there is no file storage or database. Phone checks validate format, not whether a number exists.

The original coursework provided the menu, member operations, matching, formatting, and sorting. This maintained version adds blank-name and phone-input checks, name-spacing normalization, and graceful handling of closed input. All bundled contacts are fictional examples using 555-01xx numbers.

[Validation notes](../../../VALIDATION.md) describe the recorded runtime checks and their limits.

<details>
<summary>Build directly without the launcher</summary>

From this project folder, using a JDK:

PowerShell:

```powershell
New-Item -ItemType Directory -Path build -Force | Out-Null
javac -proc:none -encoding UTF-8 -d build src/PhoneDirectory.java
java -cp build PhoneDirectory
```

macOS/Linux shell:

```sh
mkdir -p build
javac -proc:none -encoding UTF-8 -d build src/PhoneDirectory.java
java -cp build PhoneDirectory
```

</details>

[Back to the project index](../../../README.md)
