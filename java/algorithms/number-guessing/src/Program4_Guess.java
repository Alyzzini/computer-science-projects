// Number guessing game. See README.md for usage.
import java.util.Random;
import java.util.Scanner;

public class Program4_Guess {
    public static void main(String[] args) {
        int magic = new Random().nextInt(101);
        System.out.println("Guess a magic number between 0 and 100:");
        try (Scanner input = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter your guess: ");
                if (!input.hasNext()) {
                    System.out.println("Input ended; game stopped.");
                    return;
                }
                int guess;
                try { guess = Integer.parseInt(input.next()); }
                catch (NumberFormatException e) {
                    System.out.println("Enter a whole number from 0 to 100.");
                    continue;
                }
                if (guess < 0 || guess > 100) {
                    System.out.println("Enter a whole number from 0 to 100.");
                    continue;
                }
                if (guess > magic) System.out.println("Your guess is too high");
                else if (guess < magic) System.out.println("Your guess is too low");
                else {
                    System.out.println("Yes, you got it!! the number is " + magic);
                    break;
                }
            }
        }
    }
}
