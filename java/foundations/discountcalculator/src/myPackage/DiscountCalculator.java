// DiscountCalculator. See README.md for usage.
package myPackage;
import java.util.Locale;
import java.util.NoSuchElementException;

public class DiscountCalculator {
    public static void main(String[] args) {
        final double RETAIL_PRICE = 99.0;
        try (ConsoleInput input = new ConsoleInput()) {
            int quantity = input.readInt("Number of packages (0 or more): ", 0, Integer.MAX_VALUE);
            double rate = quantity >= 100 ? 0.50 : quantity >= 50 ? 0.40 : quantity >= 20 ? 0.30 : quantity >= 10 ? 0.20 : 0.0;
            double retail = quantity * RETAIL_PRICE;
            double discount = retail * rate;
            System.out.printf(Locale.US, "Discounted amount: $%.2f%n", discount);
            System.out.printf(Locale.US, "Total amount after discount: $%.2f%n", retail - discount);
        } catch (NoSuchElementException ex) {
            System.out.println("Input ended. Goodbye.");
        }
    }
}
