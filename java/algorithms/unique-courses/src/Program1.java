// Sorted unique course listing. See README.md for usage.
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.TreeSet;

public class Program1 {
    public static void main(String[] args) {
        if (args.length > 1) { System.out.println("Usage: supply at most one input-file path."); return; }
        String filename = args.length == 1 ? args[0] : "classes.txt";
        Set<String> courses = new TreeSet<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filename), StandardCharsets.UTF_8)) {
            String line;
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                line = line.trim();
                if (line.isEmpty()) continue;
                String[] parts = line.split("\\s+");
                if (parts.length < 2)
                    throw new IllegalArgumentException("Line " + lineNumber + " needs an identifier and course token.");
                courses.add(parts[1]);
            }
            System.out.println(courses);
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        }
    }
}
