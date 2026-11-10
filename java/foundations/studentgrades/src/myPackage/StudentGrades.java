// StudentGrades. See README.md for usage.
package myPackage;
import java.util.Locale;
import java.util.NoSuchElementException;

public class StudentGrades {
    public static void main(String[] args) {
        try (ConsoleInput input = new ConsoleInput()) {
            double first = input.readDouble("Score 1 (0-100): ", 0, 100);
            double second = input.readDouble("Score 2 (0-100): ", 0, 100);
            double third = input.readDouble("Score 3 (0-100): ", 0, 100);
            double average = (first + second + third) / 3.0;
            char grade = average >= 90 ? 'A' : average >= 80 ? 'B' : average >= 70 ? 'C' : average >= 60 ? 'D' : 'F';
            System.out.printf(Locale.US, "Average: %.2f%nGrade: %c%n", average, grade);
        } catch (NoSuchElementException ex) {
            System.out.println("Input ended. Goodbye.");
        }
    }
}
