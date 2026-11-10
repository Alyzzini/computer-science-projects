// Regional election tally exercise. See README.md for usage.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program2 {
    private static int nonnegativeCount(Scanner input, String label) {
        if (!input.hasNext()) throw new IllegalArgumentException("Missing " + label + ".");
        int count;
        try { count = Integer.parseInt(input.next()); }
        catch (NumberFormatException e) { throw new IllegalArgumentException(label + " must be a whole number."); }
        if (count < 0) throw new IllegalArgumentException(label + " cannot be negative.");
        return count;
    }

    public static void main(String[] args) {
        if (args.length > 1) { System.out.println("Usage: supply at most one input-file path."); return; }
        String filename = args.length == 1 ? args[0] : "election.txt";
        try (Scanner input = new Scanner(new File(filename), "UTF-8")) {
            int regions = nonnegativeCount(input, "region count");
            for (int region = 0; region < regions; region++) {
                int votes = nonnegativeCount(input, "vote count for region " + (region + 1));
                Map<String, Integer> counts = new HashMap<>();
                for (int i = 0; i < votes; i++) {
                    if (!input.hasNext()) throw new IllegalArgumentException("Missing vote in region " + (region + 1) + ".");
                    String name = input.next();
                    counts.put(name, counts.getOrDefault(name, 0) + 1);
                }
                String winner = null;
                int maxVotes = 0;
                for (Map.Entry<String, Integer> entry : counts.entrySet()) {
                    if (entry.getValue() > maxVotes) {
                        maxVotes = entry.getValue();
                        winner = entry.getKey();
                    }
                }
                if (maxVotes > votes / 2) System.out.println(winner + " won the election.");
                else System.out.println("Nobody won! A special runoff election will be held.");
                if (region != regions - 1) System.out.println();
            }
            if (input.hasNext()) throw new IllegalArgumentException("Extra tokens after declared regions.");
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
