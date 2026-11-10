// Rectangle Area and Perimeter Calculator. See README.md for usage.
import javax.swing.*;

public class RectangleApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createWindow());
    }

    private static void createWindow() {

        JFrame window = new JFrame("Rectangle Calculator");
        window.setSize(300, 250);
        window.setLayout(null);
        window.setResizable(false);

        JLabel lengthLabel = new JLabel("Length:");
        lengthLabel.setBounds(20, 20, 80, 25);
        JTextField lengthField = new JTextField();
        lengthField.setBounds(100, 20, 150, 25);

        JLabel widthLabel = new JLabel("Width:");
        widthLabel.setBounds(20, 60, 80, 25);
        JTextField widthField = new JTextField();
        widthField.setBounds(100, 60, 150, 25);

        JLabel areaLabel = new JLabel("Area:");
        areaLabel.setBounds(20, 100, 80, 25);
        JTextField areaField = new JTextField();
        areaField.setEditable(false);
        areaField.setBounds(100, 100, 150, 25);

        JLabel perimeterLabel = new JLabel("Perimeter:");
        perimeterLabel.setBounds(20, 140, 80, 25);
        JTextField perimeterField = new JTextField();
        perimeterField.setEditable(false);
        perimeterField.setBounds(100, 140, 150, 25);

        JButton calcButton = new JButton("Calculate");
        calcButton.setBounds(40, 180, 100, 30);

        JButton resetButton = new JButton("Reset");
        resetButton.setBounds(150, 180, 100, 30);

        calcButton.addActionListener(e -> {
            areaField.setText("");
            perimeterField.setText("");
            try {
                double length = Double.parseDouble(lengthField.getText());
                double width = Double.parseDouble(widthField.getText());

                if (!Double.isFinite(length) || !Double.isFinite(width) || length <= 0 || width <= 0) {
                    throw new IllegalArgumentException("Dimensions must be positive and finite.");
                }
                double area = length * width;
                double perimeter = 2 * (length + width);

                if (!Double.isFinite(area) || !Double.isFinite(perimeter) || area <= 0 || perimeter <= 0) {
                    throw new IllegalArgumentException("Result outside numeric range.");
                }
                areaField.setText(area + "");
                perimeterField.setText(perimeter + "");

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(window, "Enter positive finite dimensions with finite results.");
            }
        });

        resetButton.addActionListener(e -> {
            lengthField.setText("");
            widthField.setText("");
            areaField.setText("");
            perimeterField.setText("");
        });

        window.add(lengthLabel);
        window.add(lengthField);
        window.add(widthLabel);
        window.add(widthField);
        window.add(areaLabel);
        window.add(areaField);
        window.add(perimeterLabel);
        window.add(perimeterField);
        window.add(calcButton);
        window.add(resetButton);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
