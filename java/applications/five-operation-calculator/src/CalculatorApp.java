// Five-operation Calculator. See README.md for usage.
import javax.swing.*;

public class CalculatorApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createWindow());
    }

    private static void createWindow() {

        JFrame frame = new JFrame("Simple Calculator");
        frame.setSize(320, 300);
        frame.setLayout(null);
        frame.setResizable(false);

        // Inputs
        JLabel lblNum1 = new JLabel("Enter first number:");
        lblNum1.setBounds(20, 20, 150, 25);
        JTextField txtNum1 = new JTextField();
        txtNum1.setBounds(160, 20, 120, 25);

        JLabel lblNum2 = new JLabel("Enter second number:");
        lblNum2.setBounds(20, 60, 150, 25);
        JTextField txtNum2 = new JTextField();
        txtNum2.setBounds(160, 60, 120, 25);

        // Result
        JLabel lblResult = new JLabel("Result:");
        lblResult.setBounds(20, 100, 150, 25);
        JTextField txtResult = new JTextField();
        txtResult.setBounds(160, 100, 120, 25);
        txtResult.setEditable(false);

        // Buttons
        JButton btnAdd = new JButton("+");
        btnAdd.setBounds(30, 150, 60, 30);

        JButton btnSub = new JButton("-");
        btnSub.setBounds(100, 150, 60, 30);

        JButton btnMul = new JButton("*");
        btnMul.setBounds(170, 150, 60, 30);

        JButton btnMod = new JButton("%");
        btnMod.setBounds(240, 150, 60, 30);

        JButton btnPow = new JButton("^");
        btnPow.setBounds(80, 200, 60, 30);

        JButton btnClear = new JButton("Clear");
        btnClear.setBounds(160, 200, 100, 30);

        // Button actions
        btnAdd.addActionListener(e -> calculate(txtNum1, txtNum2, txtResult, "+"));
        btnSub.addActionListener(e -> calculate(txtNum1, txtNum2, txtResult, "-"));
        btnMul.addActionListener(e -> calculate(txtNum1, txtNum2, txtResult, "*"));
        btnMod.addActionListener(e -> calculate(txtNum1, txtNum2, txtResult, "%"));
        btnPow.addActionListener(e -> calculate(txtNum1, txtNum2, txtResult, "^"));

        btnClear.addActionListener(e -> {
            txtNum1.setText("");
            txtNum2.setText("");
            txtResult.setText("");
        });

        // Add components
        frame.add(lblNum1);
        frame.add(txtNum1);
        frame.add(lblNum2);
        frame.add(txtNum2);
        frame.add(lblResult);
        frame.add(txtResult);
        frame.add(btnAdd);
        frame.add(btnSub);
        frame.add(btnMul);
        frame.add(btnMod);
        frame.add(btnPow);
        frame.add(btnClear);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Method to handle calculations
    public static void calculate(JTextField num1, JTextField num2, JTextField result, String op) {
        result.setText("");
        try {
            double a = Double.parseDouble(num1.getText());
            double b = Double.parseDouble(num2.getText());
            if (!Double.isFinite(a) || !Double.isFinite(b)) {
                throw new IllegalArgumentException("Inputs must be finite.");
            }
            if ("%".equals(op) && b == 0) {
                throw new IllegalArgumentException("Remainder by zero is undefined.");
            }
            double res;

            if (java.util.Objects.equals(op, "+")) res = a + b;
            else if (java.util.Objects.equals(op, "-")) res = a - b;
            else if (java.util.Objects.equals(op, "*")) res = a * b;
            else if (java.util.Objects.equals(op, "%")) res = a % b;
            else if (java.util.Objects.equals(op, "^")) res = Math.pow(a, b);
            else throw new IllegalArgumentException("Unknown operation.");
            if (!Double.isFinite(res)) {
                throw new IllegalArgumentException("Operation has no finite real result.");
            }

            result.setText(String.valueOf(res));

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Enter finite numbers and choose an operation with a finite real result.\n" + e.getMessage());
        }
    }
}
