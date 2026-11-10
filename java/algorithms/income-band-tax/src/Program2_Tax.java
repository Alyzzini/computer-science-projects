// Income-band tax exercise. See README.md for usage.
import java.util.Scanner;

public class Program2_Tax {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            double income = readNonNegative(input, "Enter the income: ");
            double rate;
            if (income <= 5000) rate = 0.0;
            else if (income <= 10000) rate = 0.03;
            else if (income <= 20000) rate = 0.055;
            else if (income <= 40000) rate = 0.108;
            else rate = 0.237;
            double tax = income * rate;
            if (!Double.isFinite(tax) || tax >= Long.MAX_VALUE)
                throw new IllegalArgumentException("Tax result is outside the supported whole-dollar range.");
            System.out.println("The tax owed is $" + Math.round(tax));
        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        }
    }

    private static double readNonNegative(Scanner input, String prompt) {
        System.out.print(prompt);
        if (!input.hasNext()) throw new IllegalArgumentException("Input ended before a value was supplied.");
        double value;
        try { value = Double.parseDouble(input.next()); }
        catch (NumberFormatException e) { throw new IllegalArgumentException("Enter a finite nonnegative number."); }
        if (!Double.isFinite(value) || value < 0)
            throw new IllegalArgumentException("Enter a finite nonnegative number.");
        return value;
    }
}
