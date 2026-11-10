// Car Inventory Lookup. See README.md for usage.
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.net.URL;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.HashMap;
import java.util.Map;

public class CarInventoryApp extends JFrame {
    private JTextField vehicleIdField, makeField, modelField, yearField, priceField, statusField;
    private JLabel imageLabel;
    private JButton searchButton, showPictureButton;

    private final Map<String, Car> inventory = new HashMap<>();
    private Car currentCar = null;

    public CarInventoryApp() {
        setTitle("Car Inventory");
        setSize(720, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        JLabel titleLabel = new JLabel("Car Inventory");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        titleLabel.setBounds(280, 45, 170, 30);
        add(titleLabel);

        JLabel vehicleIdLabel = new JLabel("Vehicle ID");
        vehicleIdLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        vehicleIdLabel.setBounds(50, 110, 120, 25);
        add(vehicleIdLabel);

        vehicleIdField = new JTextField();
        vehicleIdField.setBounds(200, 110, 105, 28);
        add(vehicleIdField);

        JLabel makeLabel = new JLabel("Make");
        makeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        makeLabel.setBounds(50, 155, 120, 25);
        add(makeLabel);

        makeField = new JTextField();
        makeField.setBounds(200, 155, 105, 28);
        makeField.setEditable(false);
        add(makeField);

        JLabel modelLabel = new JLabel("Model");
        modelLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        modelLabel.setBounds(50, 200, 120, 25);
        add(modelLabel);

        modelField = new JTextField();
        modelField.setBounds(200, 200, 105, 28);
        modelField.setEditable(false);
        add(modelField);

        JLabel yearLabel = new JLabel("Year");
        yearLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        yearLabel.setBounds(50, 245, 120, 25);
        add(yearLabel);

        yearField = new JTextField();
        yearField.setBounds(200, 245, 105, 28);
        yearField.setEditable(false);
        add(yearField);

        JLabel priceLabel = new JLabel("Price");
        priceLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        priceLabel.setBounds(50, 290, 120, 25);
        add(priceLabel);

        priceField = new JTextField();
        priceField.setBounds(200, 290, 105, 28);
        priceField.setEditable(false);
        add(priceField);

        imageLabel = new JLabel("", SwingConstants.CENTER);
        imageLabel.setBounds(400, 115, 245, 245);
        imageLabel.setBorder(new LineBorder(Color.BLACK));
        add(imageLabel);

        searchButton = new JButton("Search");
        searchButton.setBounds(25, 405, 110, 30);
        add(searchButton);

        statusField = new JTextField();
        statusField.setBounds(160, 405, 110, 30);
        statusField.setEditable(false);
        add(statusField);

        showPictureButton = new JButton("Show Picture");
        showPictureButton.setBounds(355, 405, 165, 30);
        add(showPictureButton);

        showPictureButton.setEnabled(false);
        vehicleIdField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { clearSelection(); }
            public void removeUpdate(DocumentEvent e) { clearSelection(); }
            public void changedUpdate(DocumentEvent e) { clearSelection(); }
        });
        loadInventory();

        searchButton.addActionListener(e -> searchCar());
        showPictureButton.addActionListener(e -> showPicture());
    }

    // Historical demo prices retained; new images are generic replacement placeholders.
    private void loadInventory() {
    inventory.put("1001", new Car("1001", "Toyota", "Camry", 2026, 28999.99, "TOYOTA/camry.png"));
    inventory.put("1002", new Car("1002", "Toyota", "Corolla", 2026, 23999.99, "TOYOTA/corolla.png"));
    inventory.put("1003", new Car("1003", "Toyota", "Prius", 2026, 29999.99, "TOYOTA/prius.png"));
    inventory.put("1004", new Car("1004", "Toyota", "RAV4", 2026, 32999.99, "TOYOTA/rav4.png"));
    inventory.put("1005", new Car("1005", "Toyota", "Highlander", 2026, 39999.99, "TOYOTA/highlander.png"));
    inventory.put("1006", new Car("1006", "Toyota", "Corolla Cross", 2026, 27999.99, "TOYOTA/corollacross.png"));
    inventory.put("1007", new Car("1007", "Toyota", "Tacoma", 2026, 37999.99, "TOYOTA/tacoma.png"));
    inventory.put("1008", new Car("1008", "Toyota", "4Runner", 2026, 44999.99, "TOYOTA/4runner.png"));
    inventory.put("1009", new Car("1009", "Toyota", "Crown", 2026, 41999.99, "TOYOTA/crown.png"));
    inventory.put("1010", new Car("1010", "Toyota", "bZ", 2026, 34999.99, "TOYOTA/bz.png"));
}

    private void clearSelection() {
        currentCar = null;
        makeField.setText(""); modelField.setText(""); yearField.setText(""); priceField.setText("");
        statusField.setText(""); imageLabel.setIcon(null); imageLabel.setText("");
        showPictureButton.setEnabled(false);
    }

    private void searchCar() {
        String id = vehicleIdField.getText().trim();

        if (inventory.containsKey(id)) {
            currentCar = inventory.get(id);
            makeField.setText(currentCar.make);
            modelField.setText(currentCar.model);
            yearField.setText(String.valueOf(currentCar.year));
            priceField.setText(String.format("$%,.2f", currentCar.price));
            statusField.setText("Found");
            showPictureButton.setEnabled(true);
            imageLabel.setIcon(null);
            imageLabel.setText("");
        } else {
            currentCar = null;
            makeField.setText("");
            modelField.setText("");
            yearField.setText("");
            priceField.setText("");
            imageLabel.setIcon(null);
            imageLabel.setText("");
            statusField.setText("Not found");
            showPictureButton.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Vehicle ID not found.");
        }
    }

    private void showPicture() {
        if (currentCar == null) {
            JOptionPane.showMessageDialog(this, "Search for a car first.");
            return;
        }

        URL file = getClass().getResource("/" + currentCar.imagePath);

        if (file == null) {
            imageLabel.setIcon(null);
            imageLabel.setText("Image not found");
            JOptionPane.showMessageDialog(this,
                    "Could not find image:\n" + currentCar.imagePath);
            return;
        }

        ImageIcon icon = new ImageIcon(file);
        Image scaledImage = icon.getImage().getScaledInstance(
                imageLabel.getWidth(),
                imageLabel.getHeight(),
                Image.SCALE_SMOOTH
        );

        imageLabel.setText("");
        imageLabel.setIcon(new ImageIcon(scaledImage));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CarInventoryApp().setVisible(true));
    }

    static class Car {
        String vehicleId;
        String make;
        String model;
        int year;
        double price;
        String imagePath;

        Car(String vehicleId, String make, String model, int year, double price, String imagePath) {
            this.vehicleId = vehicleId;
            this.make = make;
            this.model = model;
            this.year = year;
            this.price = price;
            this.imagePath = imagePath;
        }
    }
}
