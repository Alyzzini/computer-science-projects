// BMI. See README.md for usage.
package myPackage;
import java.util.Locale;
import java.util.NoSuchElementException;

public class BMI {
    public static void main(String[] args) {
        final double KILOGRAMS_PER_POUND = 0.45359237;
        final double METERS_PER_INCH = 0.0254;
        try (ConsoleInput input = new ConsoleInput()) {
            double bmi;
            while (true) {
                double pounds = input.readDouble("Weight in pounds (positive): ", Double.MIN_VALUE, Double.MAX_VALUE);
                double inches = input.readDouble("Height in inches (positive): ", Double.MIN_VALUE, Double.MAX_VALUE);
                double kilograms = pounds * KILOGRAMS_PER_POUND;
                double meters = inches * METERS_PER_INCH;
                bmi = kilograms / (meters * meters);
                if (Double.isFinite(bmi) && bmi > 0.0) break;
                System.out.println("Those measurements exceed the supported numeric range. Enter both again.");
            }
            System.out.printf(Locale.US, "BMI: %.2f%n", bmi);
            System.out.println("Educational calculation only; these are the original exercise messages.");
            if (bmi < 18.5) System.out.println("Monitor Health Parameters");
            else if (bmi < 25) System.out.println("Doing great");
            else if (bmi <= 30) System.out.println("Implement Lifestyle Changes");
            else System.out.println("Join a Weight Management Program");
        } catch (NoSuchElementException ex) {
            System.out.println("Input ended. Goodbye.");
        }
    }
}
