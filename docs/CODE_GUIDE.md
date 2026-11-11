# A short guide to the code

Start with the projects below to see collection handling, a desktop workflow, and a few focused algorithms. Each is independent; the rest of the collection is in the [catalog](../CATALOG.md).

## Phone Directory

**[Project and demo steps](../java/applications/phone-directory/)** · **[Source](../java/applications/phone-directory/src/PhoneDirectory.java)** · **[Captured console session](demos/phone-directory.txt)**

`runDirectory()` dispatches menu choices. A nested `Member` class holds each contact, and an `ArrayList<Member>` stores the directory. Follow `findMember()` for name lookup, `formatPhoneNumber()` for formatting, and `sortByLastName()` for the manual sort.

The list makes iteration and the small console workflow easy to follow. Lookup scans the records; the nested-loop sort is quadratic. Records are kept in memory and reset when the process closes. Input normalization is a format check, not proof that a phone number exists.

## Restaurant Order Calculator

**[Project and demo steps](../java/applications/fast-food-order-calculator/)** · **[Source](../java/applications/fast-food-order-calculator/src/FastFoodRestaurant.java)**

The Swing listeners keep the selected-item text and calculated amounts in sync. `subtotalCents()` totals the selections, `totalCents()` includes the fixed tax, and `updateAmounts()` refreshes the display. `invalidatePayment()` clears a stale change result after an edit. `calculateTotal()` checks the payment before calculating change.

The maintained version uses integer cents for fixed-price money calculations and explicit rounding for tax. This is an educational order calculator: one order at a time, no saved history, and no payment service. The project's notes distinguish these current behaviors from its original version.

## Data structures and file input

**[Collection overview](../java/algorithms/)**

| Exercise | Source entry point | Design to inspect |
| --- | --- | --- |
| Stack partition | [Main.java](../java/algorithms/stack-partition/src/splitStackProgram/Main.java) | Two queues separate negative and nonnegative values before rebuilding the stack. The result is a sign partition, not a numeric sort. |
| Delimiter validation | [Main.java](../java/algorithms/delimiter-validation/src/Main.java) | `isValidExpression()` tracks opening delimiters with a stack and rejects mismatched or leftover pairs. It does not parse an expression's grammar. |
| Unique courses | [Program1.java](../java/algorithms/unique-courses/src/Program1.java) | A `TreeSet` combines duplicate removal with sorted output while reading text records. |
| Regional vote tally | [Program2.java](../java/algorithms/regional-vote-tally/src/Program2.java) | A `HashMap` counts candidate tokens, followed by a strict-majority decision. It is a classroom tally, not election administration software. |

The four project READMEs include sample input/output, complexity notes, and file-format limits.

## Student Information Browser

**[Project and screenshot](../java/applications/student-information-browser/)**

- [Student.java](../java/applications/student-information-browser/src/Student.java) stores the immutable record fields.
- [StudentInformationApp.java](../java/applications/student-information-browser/src/StudentInformationApp.java) starts the interface on Swing's event-dispatch thread.
- [StudentInformationFrame.java](../java/applications/student-information-browser/src/StudentInformationFrame.java) builds the form, handles navigation, and updates the displayed record and button states.

`showStudent()` refreshes the read-only fields and record position; `setButtonState()` handles the first and last record. This separation keeps data and interface responsibilities distinct. The sample contains four records and has no add/edit/delete workflow or database.

## Check an example

From the repository root, run:

```sh
python tools/check_examples.py
```

This builds and runs five console examples through the repository launcher and checks their output. It does not launch the Swing apps. The broader recorded validation, environment, and limits are documented in [VALIDATION.md](../VALIDATION.md).

[Back to the portfolio](../README.md)
