# Project catalog

The complete collection: 33 Java programs, three MARIE programs, and one worked cache example. Each Java folder is independent, including programs that share a class name. The reference exercises are separated from coursework.

[Selected projects](README.md) · [Code guide](docs/CODE_GUIDE.md) · [Validation notes](VALIDATION.md)

## Java applications

| Project | What it does |
| --- | --- |
| [Phone Directory](java/applications/phone-directory/) | A console phone directory built around an ArrayList of member records. |
| [Fast Food Restaurant Order Calculator](java/applications/fast-food-order-calculator/) | A Swing order calculator with sandwich choices, optional sides and drinks, an order summary, and change calculation. |
| [Student Information Browser](java/applications/student-information-browser/) | A Swing browser for a small collection of student records, with separate model, window, and application-entry classes. |
| [Car Inventory Lookup](java/applications/car-inventory-lookup/) | A Swing vehicle lookup exercise using a HashMap of sample car records. |
| [Personal Information Form](java/applications/personal-information-form/) | A Swing form exercise that checks input and displays a local summary. |
| [Clothing Catalog Browser](java/applications/clothing-catalog-browser/) | A Swing catalog browser for four clothing records stored in a two-dimensional array. |
| [Mama Mia Pizzaria](java/applications/mama-mia-pizzaria/) | A dialog-based pizza order calculator. |
| [Body Mass Index Calculator](java/applications/bmi-calculator/) | A small dialog-based exercise in numeric input, arithmetic, and conditional categories. |
| [Rectangle Area and Perimeter Calculator](java/applications/rectangle-calculator/) | A Swing calculator for a rectangle's area and perimeter. |
| [Five-operation Calculator](java/applications/five-operation-calculator/) | A two-input Swing calculator for five arithmetic operations. |

## Java algorithms and data structures

| Project | What it does |
| --- | --- |
| [Gratuity calculator](java/algorithms/gratuity/) | A console calculator that takes a subtotal and tip percentage, then prints the gratuity and total. |
| [Income-band tax exercise](java/algorithms/income-band-tax/) | A Java console exercise that selects a rate from five income bands and rounds the resulting tax to the nearest dollar. |
| [Lottery digit matching](java/algorithms/lottery/) | A small console game that compares a two-digit guess with a random two-digit draw. |
| [Number guessing game](java/algorithms/number-guessing/) | A console guessing game with a random target from 0 through 100 and high-or-low hints. |
| [Coordinate geometry calculator](java/algorithms/coordinate-geometry/) | Calculates the slope and distance between two points with integer coordinates. |
| [Relative grade calculator](java/algorithms/relative-grades/) | Reads a group of scores and assigns letter grades relative to the highest score in the group. |
| [Bank account collection exercise](java/algorithms/bank-account-tester/) | Demonstrates object arrays, deposits and withdrawals, balance totals, filtering, and a name lookup using fictional bank accounts. |
| [Six recursive methods study wrapper](java/algorithms/recursive-methods/) | A console demonstration of recursive counting, summation, digit counting, and digit summation. |
| [Stack partition by sign](java/algorithms/stack-partition/) | Reads integer stacks from a text file and places negative integers below nonnegative integers using two queues. |
| [Balanced delimiter validator](java/algorithms/delimiter-validation/) | Checks whether parentheses, brackets, braces, and angle brackets are balanced and correctly nested. |
| [Sorted unique course listing](java/algorithms/unique-courses/) | Reads course records from a text file and prints each distinct course name in sorted order. |
| [Regional election tally exercise](java/algorithms/regional-vote-tally/) | Counts candidate tokens for several regions and reports a winner only when a candidate has a strict majority. |

## Java foundations

| Project | What it does |
| --- | --- |
| [Greeting](java/foundations/greeting/) | A short console program that prints a greeting and a synthetic profile. |
| [BMI](java/foundations/bmi/) | Converts pounds and inches to a BMI value and displays the exercise’s conditional result message. |
| [StudentGrades](java/foundations/studentgrades/) | Averages three scores and assigns a letter grade using fixed score thresholds. |
| [DiscountCalculator](java/foundations/discountcalculator/) | Calculates the discount and final price for packages priced at $99 each. |
| [InternetBills](java/foundations/internetbills/) | Calculates a monthly bill for one of three fixed service plans. |
| [MathTutoringGame](java/foundations/mathtutoringgame/) | An interactive arithmetic exercise with random addition, subtraction, and multiplication questions. |
| [ArraysAndWordFrequency](java/foundations/arraysandwordfrequency/) | Finds distinct integers in first-seen order and counts case-insensitive words in a paragraph. |
| [Account model and demonstration](java/foundations/account/) | A small account class with balance operations, interest calculations, and a console demonstration. |
| [Marathon rankings](java/foundations/marathon/) | Finds the fastest and second-fastest entries in a list of running times. |

## Extra reference exercises

These reference exercises were added during portfolio preparation. They are separate from the original course submissions.

| Project | What it does |
| --- | --- |
| [File-backed Task List](practice/file-backed-task-list/) | A console reference exercise for managing tasks stored in a UTF-8 text file. |
| [Search and Sort Practice](practice/search-and-sort/) | A reference exercise implementing insertion sort, merge sort, and first-match binary search. |
| [Cache mapping](practice/cache-mapping/) | A worked direct-mapped cache example with a synthetic address sequence. |

## MARIE assembly

- [Conditional arithmetic](marie/conditional-arithmetic/) — calculate `Z + max(X, Y)` with input and overflow guards.
- [Repeated-addition multiplication](marie/repeated-addition/) — multiply nonnegative values using the smaller operand as the loop count.
- [Multiplication subroutine](marie/multiplication-subroutine/) — use `JnS` and `JumpI` for call and return behavior.

These programs use classic MARIE instructions and signed 16-bit words. See each README for its input conventions and simulator notes.

## Project notes

The collection has 33 Java programs and three MARIE programs. The Java source includes helper classes, so the source-file count is higher than the program count. Small exercises remain separate even when they share a class name.

The bank-account collection exercise includes a reconstructed dependency; the greeting and recursion wrappers were rebuilt from the available written material. Their READMEs explain the scope. Contact and account examples are synthetic. The restaurant, car, and clothing graphics are generic replacement illustrations.

These are learning projects with limited scope: the phone directory stores data in memory, the record browsers do not edit a database, and the order calculator does not process payments. Current checks and remaining limits are described in [VALIDATION.md](VALIDATION.md).

Private school records, original assignment documents, exam questions, personal reports, and local audit files are not part of this repository. The Marathon teaching fixture has its own [attribution note](java/foundations/marathon/ATTRIBUTION.md).
