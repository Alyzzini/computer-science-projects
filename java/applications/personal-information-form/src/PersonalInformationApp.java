// Personal Information Form. See README.md for usage.
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PersonalInformationApp extends JFrame {
    private JTextField firstNameField, lastNameField, streetField, cityField;
    private JTextField phoneField, emailField;
    private JComboBox<String> stateCombo;
    private JRadioButton maleRadio, femaleRadio;
    private JButton clearButton, submitButton, quitButton;
    private final ButtonGroup genderGroup = new ButtonGroup();

    public PersonalInformationApp() {
        setTitle("Info App");
        setSize(800, 330);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(new TitledBorder("Personal Information"));
        panel.setBounds(15, 20, 755, 165);
        add(panel);

        JLabel firstNameLabel = new JLabel("First Name");
        firstNameLabel.setBounds(10, 25, 100, 25);
        panel.add(firstNameLabel);

        firstNameField = new JTextField();
        firstNameField.setBounds(110, 25, 200, 25);
        panel.add(firstNameField);

        JLabel lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setBounds(10, 52, 100, 25);
        panel.add(lastNameLabel);

        lastNameField = new JTextField();
        lastNameField.setBounds(110, 52, 200, 25);
        panel.add(lastNameField);

        JLabel streetLabel = new JLabel("Street");
        streetLabel.setBounds(10, 79, 100, 25);
        panel.add(streetLabel);

        streetField = new JTextField();
        streetField.setBounds(110, 79, 200, 25);
        panel.add(streetField);

        JLabel cityLabel = new JLabel("City");
        cityLabel.setBounds(10, 106, 100, 25);
        panel.add(cityLabel);

        cityField = new JTextField();
        cityField.setBounds(110, 106, 200, 25);
        panel.add(cityField);

        JLabel stateLabel = new JLabel("State");
        stateLabel.setBounds(10, 133, 100, 25);
        panel.add(stateLabel);

        String[] states = {
            "Select state:", "TX", "CA", "NY", "FL", "IL", "AZ", "WA", "GA", "NC"
        };
        stateCombo = new JComboBox<>(states);
        stateCombo.setBounds(110, 133, 105, 25);
        panel.add(stateCombo);

        JLabel phoneLabel = new JLabel("Phone Number");
        phoneLabel.setBounds(330, 25, 100, 25);
        panel.add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(440, 25, 280, 25);
        panel.add(phoneField);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(330, 52, 100, 25);
        panel.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(440, 52, 280, 25);
        panel.add(emailField);

        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setBounds(330, 79, 100, 25);
        panel.add(genderLabel);

        maleRadio = new JRadioButton("Male");
        maleRadio.setBounds(440, 79, 60, 25);
        maleRadio.setOpaque(false);
        panel.add(maleRadio);

        femaleRadio = new JRadioButton("Female");
        femaleRadio.setBounds(510, 79, 75, 25);
        femaleRadio.setOpaque(false);
        panel.add(femaleRadio);

        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);

        clearButton = new JButton("Clear");
        clearButton.setBounds(20, 215, 90, 25);
        add(clearButton);

        submitButton = new JButton("Submit");
        submitButton.setBounds(580, 215, 90, 25);
        add(submitButton);

        quitButton = new JButton("Quit");
        quitButton.setBounds(690, 215, 90, 25);
        add(quitButton);

        clearButton.addActionListener(e -> clearForm());

        submitButton.addActionListener(e -> {
            if (!validateForm()) return;
            String gender = maleRadio.isSelected() ? "Male"
                    : femaleRadio.isSelected() ? "Female" : "Not selected";

            String message =
                    "First Name: " + firstNameField.getText() + "\n" +
                    "Last Name: " + lastNameField.getText() + "\n" +
                    "Street: " + streetField.getText() + "\n" +
                    "City: " + cityField.getText() + "\n" +
                    "State: " + stateCombo.getSelectedItem() + "\n" +
                    "Phone Number: " + phoneField.getText() + "\n" +
                    "Email: " + emailField.getText() + "\n" +
                    "Gender: " + gender;

            JOptionPane.showMessageDialog(this, message, "Submitted Information",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        quitButton.addActionListener(e -> System.exit(0));
    }

    private boolean validateForm() {
        for (JTextField field : new JTextField[] {firstNameField, lastNameField, streetField, cityField, phoneField, emailField}) {
            field.setText(field.getText().trim());
            if (field.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete all text fields before submitting.");
                field.requestFocusInWindow();
                return false;
            }
        }
        if (stateCombo.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Choose a state from this exercise's list.");
            return false;
        }
        String phone = phoneField.getText();
        String digits = phone.replaceAll("[^0-9]", "");
        if (!phone.matches("[0-9() .-]+") || digits.length() != 10) {
            JOptionPane.showMessageDialog(this, "Enter a ten-digit phone number using digits, spaces, parentheses or hyphens.");
            return false;
        }
        if (!emailField.getText().matches("[^\\s@]+@[^\\s@]+\\.[^\\s@]+")) {
            JOptionPane.showMessageDialog(this, "Enter an email in name@example.invalid form.");
            return false;
        }
        phoneField.setText(digits.substring(0,3) + "-" + digits.substring(3,6) + "-" + digits.substring(6));
        return true;
    }

    private void clearForm() {
        firstNameField.setText("");
        lastNameField.setText("");
        streetField.setText("");
        cityField.setText("");
        phoneField.setText("");
        emailField.setText("");
        stateCombo.setSelectedIndex(0);
        genderGroup.clearSelection();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PersonalInformationApp().setVisible(true));
    }
}
