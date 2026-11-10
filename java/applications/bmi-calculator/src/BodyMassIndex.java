// Body Mass Index Calculator. See README.md for usage.
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class BodyMassIndex {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> calculateBmi());
    }

    private static void calculateBmi() {
        try {
            String weightInput = JOptionPane.showInputDialog("Enter your weight in kilograms:");
            if (weightInput == null) return;

            String heightInput = JOptionPane.showInputDialog("Enter your height in meters:");
            if (heightInput == null) return;

            double weight = Double.parseDouble(weightInput);
            double height = Double.parseDouble(heightInput);

            if (!Double.isFinite(weight) || !Double.isFinite(height) || weight <= 0 || height <= 0) {
                throw new IllegalArgumentException("Weight and height must be positive finite numbers.");
            }
            double heightSquared = height * height;
            double bmi = weight / heightSquared;
            if (!Double.isFinite(heightSquared) || heightSquared == 0 || !Double.isFinite(bmi) || bmi <= 0) {
                throw new IllegalArgumentException("Values are outside the calculator's numeric range.");
            }

            String category;
            if (bmi < 18.5) {
                category = "Underweight";
            } else if (bmi < 25) {
                category = "Normal weight";
            } else if (bmi < 30) {
                category = "Overweight";
            } else {
                category = "Obese";
            }

            String message = "Your BMI is: " + String.format("%.2f", bmi) +
                             "\nCategory: " + category;

            JOptionPane.showMessageDialog(null, message, "BMI Result", JOptionPane.INFORMATION_MESSAGE);

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Enter positive, finite numeric values within the calculator range.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
