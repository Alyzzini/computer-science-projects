// Relative grade calculator. See README.md for usage.
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int n = readInt(input, "Enter the number of students (1-10000): ", 1, 10000);
            int[] scores = new int[n];
            int best = 0;
            System.out.println("Enter " + n + " nonnegative whole-number scores:");
            for (int i = 0; i < n; i++) {
                scores[i] = readInt(input, "Score " + i + ": ", 0, Integer.MAX_VALUE);
                if (scores[i] > best) best = scores[i];
            }
            for (int i = 0; i < n; i++) {
                int s = scores[i];
                char grade;
                if (s >= best - 10) grade = 'A';
                else if (s >= best - 20) grade = 'B';
                else if (s >= best - 30) grade = 'C';
                else if (s >= best - 40) grade = 'D';
                else grade = 'F';
                System.out.println("Student " + i + " score is " + s + " and grade is " + grade);
            }
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
