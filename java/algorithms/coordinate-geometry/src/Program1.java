// Coordinate geometry calculator. See README.md for usage.
import java.util.Scanner;

public class Program1 {
    public static double slope(int x1, int y1, int x2, int y2) {
        long dx = (long) x2 - x1;
        long dy = (long) y2 - y1;
        return dx == 0 ? Double.NaN : (double) dy / dx;
    }

    public static double distance(int x1, int y1, int x2, int y2) {
        long dx = (long) x2 - x1;
        long dy = (long) y2 - y1;
        return Math.hypot((double) dx, (double) dy);
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int x1 = readInt(input, "Enter x1: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
            int y1 = readInt(input, "Enter y1: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
            int x2 = readInt(input, "Enter x2: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
            int y2 = readInt(input, "Enter y2: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
            double m = slope(x1, y1, x2, y2);
            if (Double.isNaN(m)) System.out.println("Slope: undefined (vertical or coincident points)");
            else System.out.println("Slope: " + m);
            System.out.println("Distance: " + distance(x1, y1, x2, y2));
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
