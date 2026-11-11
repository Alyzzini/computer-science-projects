# Balanced Delimiter Validator

Check whether `()`, `[]`, `{}`, and `<>` are balanced and correctly nested. The key rule is that a closing delimiter must match the most recent opening delimiter. This is a revised coursework exercise with new sample expressions.

## Example

The complete [sample file](expressions.txt) is:

```text
(a+[b*{c}])
<tag>{[()]}</tag>
([)]
)abc(
no delimiters
<[{}]>
(unclosed
[x] ==> previous annotation
```

The program prints:

```text
(a+[b*{c}]) ==> valid
<tag>{[()]}</tag> ==> valid
([)] ==> invalid
)abc( ==> invalid
no delimiters ==> valid
<[{}]> ==> valid
(unclosed ==> invalid
[x] ==> valid
```

`([)]` fails because `)` arrives while `[` is the most recent unmatched opener. Equal numbers of opening and closing symbols are not enough. The tag-like example is checked only for delimiter nesting; its text has no HTML meaning to this program.

## Implementation

[`isValidExpression` in Main.java](src/Main.java) pushes opening delimiters onto a `Stack<Character>`. For each closer, it rejects an empty stack or a mismatched top element. After the scan, the stack must be empty. This handles nesting with one pass instead of separate counts for each delimiter type.

The file loop trims lines, skips blanks, and removes any old annotation after the first `==>` marker before calling the validator. It also reports file-open and file-read errors.

## Time and memory

Let **n** be the expression's length in Java `char` units and **d** its maximum number of unmatched opening delimiters. A full validation takes **O(n) total time**, using amortized O(1) stack pushes; it may return sooner at the first mismatch. Each character is inspected once, and each stack entry is pushed and popped at most once.

The method uses **O(d) auxiliary space**, up to O(n) for an expression made entirely of opening delimiters. This excludes the input string. The console wrapper also stores the current line/expression and constructs its printed result, adding O(n) string storage for that line. It does not retain a list of all expressions.

## Run and input format

From the repository root with Python 3.9+ and JDK 17+:

```text
python tools/projects.py run algorithms/delimiter-validation
```

The default file is `expressions.txt`: one expression per nonblank UTF-8 line. To check `custom-input.txt` saved in this project folder:

```text
python tools/projects.py run algorithms/delimiter-validation -- custom-input.txt
```

## Limits

- Characters other than the four delimiter pairs are ignored. Quotes, comments, HTML, and expression grammar are not parsed.
- An empty string is balanced at the method level; blank file lines and lines empty after annotation removal are skipped.
- A late file error can be reported after earlier expression results have printed.

[Algorithms overview](../README.md) · [All projects](../../../README.md)
