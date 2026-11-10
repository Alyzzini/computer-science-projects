// Six recursive methods study wrapper. See README.md for usage.
import java.util.Scanner;

public class RecursionExercises {
    private static final int MAX_SEQUENCE = 100;

    private static void checkSequenceBound(int n) {
        if (n < 0 || n > MAX_SEQUENCE)
            throw new IllegalArgumentException("Sequence bound must be from 0 to " + MAX_SEQUENCE + ".");
    }

    public static void printDescending(int n) { checkSequenceBound(n); descending(n); }
    private static void descending(int n) {
        if (n <= 0) return;
        System.out.print(n + " ");
        descending(n - 1);
    }

    public static void printAscending(int n) { checkSequenceBound(n); ascending(n); }
    private static void ascending(int n) {
        if (n <= 0) return;
        ascending(n - 1);
        System.out.print(n + " ");
    }

    public static void printDownByTwo(int n) { checkSequenceBound(n); downByTwo(n); }
    private static void downByTwo(int n) {
        if (n < 0) return;
        System.out.print(n + " ");
        downByTwo(n - 2);
    }

    public static int sumUp(int n) { checkSequenceBound(n); return sumRange(n); }
    private static int sumRange(int n) { return n <= 0 ? 0 : n + sumRange(n - 1); }

    public static int numDigits(int n) { return digitsOf(Math.abs((long) n)); }
    private static int digitsOf(long magnitude) {
        return magnitude < 10 ? 1 : 1 + digitsOf(magnitude / 10);
    }

    public static int sumDigits(int n) { return sumDigitsOf(Math.abs((long) n)); }
    private static int sumDigitsOf(long magnitude) {
        return magnitude < 10 ? (int) magnitude : (int) (magnitude % 10) + sumDigitsOf(magnitude / 10);
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int bound = readInt(input, "Sequence bound (0-100): ", 0, MAX_SEQUENCE);
            int number = readInt(input, "Integer for digit operations: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
            System.out.print("Descending: "); printDescending(bound); System.out.println();
            System.out.print("Ascending: "); printAscending(bound); System.out.println();
            System.out.print("Down by two: "); printDownByTwo(bound); System.out.println();
            System.out.println("Sum 1 through n: " + sumUp(bound));
            System.out.println("Digit count: " + numDigits(number));
            System.out.println("Digit sum: " + sumDigits(number));
        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        }
    }

    private static int readInt(Scanner input, String prompt, int minimum, int maximum) {
        System.out.print(prompt);
        if (!input.hasNext()) throw new IllegalArgumentException("Input ended before a value was supplied.");
        String token = input.next();
        int value;
        try { value = Integer.parseInt(token); }
        catch (NumberFormatException e) { throw new IllegalArgumentException("Enter a whole number in the supported range."); }
        if (value < minimum || value > maximum)
            throw new IllegalArgumentException("Value must be between " + minimum + " and " + maximum + ".");
        return value;
    }
}
