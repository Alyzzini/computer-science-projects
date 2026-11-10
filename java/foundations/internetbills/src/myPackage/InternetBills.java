// InternetBills. See README.md for usage.
package myPackage;
import java.util.Locale;
import java.util.NoSuchElementException;

public class InternetBills {
    public static void main(String[] args) {
        try (ConsoleInput input = new ConsoleInput()) {
            String plan;
            while (true) {
                plan = input.readLine("Package (A, B, or C): ").trim().toUpperCase(Locale.ROOT);
                if (plan.equals("A") || plan.equals("B") || plan.equals("C")) break;
                System.out.println("Enter exactly A, B, or C.");
            }
            double hours = input.readDouble("Hours used (0-744): ", 0, 744);
            double bill;
            switch (plan) {
                case "A": bill = 9.95 + Math.max(0, hours - 10) * 2.00; break;
                case "B": bill = 13.95 + Math.max(0, hours - 20); break;
                default: bill = 19.95;
            }
            System.out.printf(Locale.US, "Package %s: Your bill is $%.2f%n", plan, bill);
        } catch (NoSuchElementException ex) {
            System.out.println("Input ended. Goodbye.");
        }
    }
}
