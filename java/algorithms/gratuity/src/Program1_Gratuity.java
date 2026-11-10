// Gratuity calculator. See README.md for usage.
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

public class Program1_Gratuity {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            double subtotal = readNonNegative(input, "Enter the subtotal: ");
            double ratePercent = readNonNegative(input, "Enter the gratuity rate: ");
            double gratuity = subtotal * (ratePercent / 100.0);
            double total = subtotal + gratuity;
            if (!Double.isFinite(gratuity) || !Double.isFinite(total))
                throw new IllegalArgumentException("The calculation is too large.");
            DecimalFormat df = new DecimalFormat("0.##", DecimalFormatSymbols.getInstance(Locale.US));
            System.out.println("The gratuity is: $" + df.format(gratuity) + " and the total is $" + df.format(total));
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
