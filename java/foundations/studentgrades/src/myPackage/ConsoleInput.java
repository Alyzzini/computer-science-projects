// StudentGrades. See README.md for usage.
package myPackage;

import java.util.NoSuchElementException;
import java.util.Scanner;

/** New replacement helper: one response per line; clean EOF and retry on bad input. */
final class ConsoleInput implements AutoCloseable {
    private final Scanner scanner = new Scanner(System.in);

    String readLine(String prompt) {
        System.out.print(prompt);
        if (!scanner.hasNextLine()) throw new NoSuchElementException("Input ended.");
        return scanner.nextLine();
    }

    int readInt(String prompt, int minimum, int maximum) {
        while (true) {
            try {
                int value = Integer.parseInt(readLine(prompt).trim());
                if (value >= minimum && value <= maximum) return value;
            } catch (NumberFormatException ex) {
                // Report the same bounded-input instruction for text or integer overflow.
            }
            System.out.println("Enter a whole number from " + minimum + " to " + maximum + ".");
        }
    }

    double readDouble(String prompt, double minimum, double maximum) {
        while (true) {
            try {
                double value = Double.parseDouble(readLine(prompt).trim());
                if (Double.isFinite(value) && value >= minimum && value <= maximum) return value;
            } catch (NumberFormatException ex) {
                // NaN and infinity are rejected by the finite check above.
            }
            System.out.println("Enter a finite number from " + minimum + " to " + maximum + ".");
        }
    }

    String readBoundedLine(String prompt, int maximumLength, boolean allowEmpty) {
        while (true) {
            String value = readLine(prompt);
            if (value.length() <= maximumLength && (allowEmpty || !value.trim().isEmpty())) return value;
            System.out.println("Enter " + (allowEmpty ? "at most " : "1 to ") + maximumLength + " characters.");
        }
    }

    @Override public void close() { scanner.close(); }
}
