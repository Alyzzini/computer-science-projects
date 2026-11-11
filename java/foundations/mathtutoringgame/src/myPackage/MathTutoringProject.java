// MathTutoringGame. See README.md for usage.
package myPackage;
import java.util.NoSuchElementException;

/** Maintained replacement for the original arithmetic practice submission. */
public class MathTutoringProject {
    public static void main(String[] args) {
        final int MIN = 10, MAX = 50;
        try (ConsoleInput input = new ConsoleInput()) {
            while (true) {
                System.out.println("\nMath Tutoring Game\n1. Addition\n2. Subtraction\n3. Multiplication\n4. Exit");
                int choice = input.readInt("Selection: ", 1, 4);
                if (choice == 4) { System.out.println("Goodbye! Come back again!"); break; }
                int first = MIN + (int) (Math.random() * (MAX - MIN + 1));
                int second = MIN + (int) (Math.random() * (MAX - MIN + 1));
                int correct = choice == 1 ? first + second : choice == 2 ? first - second : first * second;
                char operation = choice == 1 ? '+' : choice == 2 ? '-' : 'x';
                System.out.printf("%n      %d%n%c     %d%n--------%n", first, operation, second);
                int answer = input.readInt("Answer: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                System.out.println(answer == correct ? "Correct!" : "Incorrect! The correct answer is: " + correct);
            }
        } catch (NoSuchElementException ex) {
            System.out.println("Input ended. Goodbye.");
        }
    }
}
