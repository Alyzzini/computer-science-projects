// ArraysAndWordFrequency. See README.md for usage.
package myPackage;
import java.util.NoSuchElementException;

public class Assignment {
    public static int countDistinct(int[] numbers, int size, int[] distinct) {
        if (numbers == null || distinct == null || size < 0 || size > numbers.length || distinct.length < size)
            throw new IllegalArgumentException("Valid arrays and output capacity for size are required.");
        int count = 0;
        for (int i = 0; i < size; i++) {
            boolean isNew = true;
            for (int j = 0; j < count; j++) {
                if (numbers[i] == distinct[j]) { isNew = false; break; }
            }
            if (isNew) distinct[count++] = numbers[i];
        }
        return count;
    }

    public static int countOccurrences(String[] words, String word) {
        if (words == null || word == null) throw new IllegalArgumentException("Words and search term are required.");
        int count = 0;
        for (String current : words) {
            if (current == null) throw new IllegalArgumentException("Words must not contain null.");
            if (current.equalsIgnoreCase(word)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        try (ConsoleInput input = new ConsoleInput()) {
            int[] numbers = new int[10];
            for (int i = 0; i < numbers.length; i++)
                numbers[i] = input.readInt("Integer " + (i + 1) + " of 10: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
            int[] distinct = new int[10];
            int count = countDistinct(numbers, numbers.length, distinct);
            System.out.println("The number of distinct numbers is: " + count);
            System.out.print("The distinct numbers are:");
            for (int i = 0; i < count; i++) System.out.print(" " + distinct[i]);
            System.out.println();
            String paragraph = input.readBoundedLine("One-line paragraph (up to 100000 characters): ", 100000, true).trim();
            String[] words = paragraph.isEmpty() ? new String[0] : paragraph.split("\\s+");
            int searchCount = input.readInt("Number of search terms (0-1000): ", 0, 1000);
            for (int i = 0; i < searchCount; i++) {
                String term;
                while (true) {
                    term = input.readBoundedLine("Search term " + (i + 1) + ": ", 1000, false).trim();
                    if (term.matches("\\S+")) break;
                    System.out.println("Enter one whitespace-delimited term.");
                }
                System.out.println("'" + term + "' occurs " + countOccurrences(words, term) + " time(s).");
            }
        } catch (NoSuchElementException ex) {
            System.out.println("Input ended. Goodbye.");
        }
    }
}
