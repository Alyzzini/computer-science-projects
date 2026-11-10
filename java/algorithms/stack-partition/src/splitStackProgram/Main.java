// Stack partition by sign. See README.md for usage.
package splitStackProgram;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void splitStack(Stack<Integer> stack) {
        if (stack == null) throw new IllegalArgumentException("Stack is required.");
        Queue<Integer> negatives = new LinkedList<>();
        Queue<Integer> nonNegatives = new LinkedList<>();
        while (!stack.isEmpty()) {
            int value = stack.pop();
            if (value < 0) negatives.add(value);
            else nonNegatives.add(value);
        }
        while (!negatives.isEmpty()) stack.push(negatives.remove());
        while (!nonNegatives.isEmpty()) stack.push(nonNegatives.remove());
    }

    private static String nextNonblank(Scanner input) {
        while (input.hasNextLine()) {
            String line = input.nextLine().trim();
            if (!line.isEmpty()) return line;
        }
        return null;
    }

    public static void main(String[] args) {
        if (args.length > 1) { System.out.println("Usage: supply at most one input-file path."); return; }
        String filename = args.length == 1 ? args[0] : "splitStack.txt";
        try (Scanner input = new Scanner(new File(filename), "UTF-8")) {
            String header = nextNonblank(input);
            if (header == null) throw new IllegalArgumentException("Missing case count.");
            int cases;
            try { cases = Integer.parseInt(header); }
            catch (NumberFormatException e) { throw new IllegalArgumentException("Case count must be one whole number."); }
            if (cases < 0) throw new IllegalArgumentException("Case count cannot be negative.");
            for (int i = 0; i < cases; i++) {
                String line = nextNonblank(input);
                if (line == null) throw new IllegalArgumentException("Missing integer line for case " + (i + 1) + ".");
                Stack<Integer> stack = new Stack<>();
                try (Scanner lineReader = new Scanner(line)) {
                    while (lineReader.hasNext()) {
                        String token = lineReader.next();
                        try { stack.push(Integer.parseInt(token)); }
                        catch (NumberFormatException e) { throw new IllegalArgumentException("Invalid integer in case " + (i + 1) + ": " + token); }
                    }
                }
                splitStack(stack);
                System.out.println(stack);
            }
            if (nextNonblank(input) != null) throw new IllegalArgumentException("Extra data after declared cases.");
            if (input.ioException() != null) {
                throw new IllegalArgumentException("Input file is not valid UTF-8 or could not be read completely.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot read input file: " + filename);
        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        }
    }
}
