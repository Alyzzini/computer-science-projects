// Lottery digit matching. See README.md for usage.
import java.util.Random;
import java.util.Scanner;

public class Program3_Lottery {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int lottery = new Random().nextInt(90) + 10;
            int guess = readInt(input, "Enter the lottery pick (two digits): ", 10, 99);
            int lotteryTens = lottery / 10;
            int lotteryOnes = lottery % 10;
            int guessTens = guess / 10;
            int guessOnes = guess % 10;
            System.out.println("The lottery number is: " + lottery);
            if (guess == lottery) System.out.println("Exact match! You won $10000");
            else if (guessTens == lotteryOnes && guessOnes == lotteryTens)
                System.out.println("Match all digits! You won $3000");
            else if (guessTens == lotteryTens || guessTens == lotteryOnes
                    || guessOnes == lotteryTens || guessOnes == lotteryOnes)
                System.out.println("Match one digit! You won $100");
            else System.out.println("Sorry, no match.");
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
