// Balanced delimiter validator. See README.md for usage.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static boolean isValidExpression(String expr) {
        if (expr == null) throw new IllegalArgumentException("Expression is required.");
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{' || ch == '<') stack.push(ch);
            else if (ch == ')' || ch == ']' || ch == '}' || ch == '>') {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((ch == ')' && top != '(') || (ch == ']' && top != '[')
                        || (ch == '}' && top != '{') || (ch == '>' && top != '<')) return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        if (args.length > 1) { System.out.println("Usage: supply at most one input-file path."); return; }
        String filename = args.length == 1 ? args[0] : "expressions.txt";
        try (Scanner input = new Scanner(new File(filename), "UTF-8")) {
            while (input.hasNextLine()) {
                String line = input.nextLine().trim();
                if (line.isEmpty()) continue;
                int arrowIndex = line.indexOf("==>");
                String expr = arrowIndex < 0 ? line : line.substring(0, arrowIndex).trim();
                if (expr.isEmpty()) continue;
                System.out.println(expr + " ==> " + (isValidExpression(expr) ? "valid" : "invalid"));
            }
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
