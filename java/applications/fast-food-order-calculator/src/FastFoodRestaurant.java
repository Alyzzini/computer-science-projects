// Fast Food Restaurant Order Calculator. See README.md for usage.
import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.math.BigDecimal;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class FastFoodRestaurant extends JFrame {

    // Integer cents avoid binary floating-point rounding in this fixed-price demo.
    final int sandwichPrice = 750;
    final int sidePrice = 250;
    final int drinkPrice = 200;
    final int shakePrice = 275;

    JRadioButton fish, chicken, turkey, burger;

    JCheckBox fries, salad, onionRings;
    JCheckBox icedTea, coffee, orange;
    JCheckBox vanillaCone, vanillaShake, strawberryShake;

    JTextArea orderBox;
    JTextField paidBox;

    JLabel subtotalLabel, taxLabel, totalLabel, changeLabel;
    JLabel pictureLabel;

    public FastFoodRestaurant() {

        setTitle("Fast Food Restaurant");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel window = new JPanel(new BorderLayout(10, 10));
        window.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setContentPane(window);

        JLabel title = new JLabel("Fast Food Restaurant", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        window.add(title, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 0));

        mainPanel.add(makeSandwichPanel(), BorderLayout.WEST);
        mainPanel.add(makeMiddlePanel(), BorderLayout.CENTER);
        mainPanel.add(makeExtrasPanel(), BorderLayout.EAST);

        window.add(mainPanel, BorderLayout.CENTER);

        orderBox = new JTextArea(6, 40);
        orderBox.setEditable(false);
        orderBox.setFont(new Font("Arial", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(orderBox);
        scrollPane.setPreferredSize(new Dimension(700, 100));
        window.add(scrollPane, BorderLayout.SOUTH);

        addButtons();
        paidBox.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { invalidatePayment(); }
            public void removeUpdate(DocumentEvent e) { invalidatePayment(); }
            public void changedUpdate(DocumentEvent e) { invalidatePayment(); }
        });

        showPicture("chicken.png");
        updateOrderBox();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JPanel makeSandwichPanel() {

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(210, 360));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Sandwiches $7.50"));

        fish = new JRadioButton("Fish Sandwich");
        chicken = new JRadioButton("Chicken Sandwich");
        turkey = new JRadioButton("Turkey Sandwich");
        burger = new JRadioButton("Burger");

        ButtonGroup sandwichGroup = new ButtonGroup();
        sandwichGroup.add(fish);
        sandwichGroup.add(chicken);
        sandwichGroup.add(turkey);
        sandwichGroup.add(burger);

        chicken.setSelected(true);

        fries = new JCheckBox("Fries");
        salad = new JCheckBox("Salad");
        onionRings = new JCheckBox("Onion Rings");

        panel.add(fish);
        panel.add(Box.createVerticalStrut(10));
        panel.add(chicken);
        panel.add(Box.createVerticalStrut(10));
        panel.add(turkey);
        panel.add(Box.createVerticalStrut(10));
        panel.add(burger);

        panel.add(Box.createVerticalStrut(25));
        panel.add(new JLabel("Sides $2.50"));
        panel.add(Box.createVerticalStrut(10));

        panel.add(fries);
        panel.add(Box.createVerticalStrut(10));
        panel.add(salad);
        panel.add(Box.createVerticalStrut(10));
        panel.add(onionRings);

        return panel;
    }

    public JPanel makeMiddlePanel() {

    JPanel panel = new JPanel();
    panel.setPreferredSize(new Dimension(260, 420));
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    pictureLabel = new JLabel("", SwingConstants.CENTER);
    pictureLabel.setPreferredSize(new Dimension(240, 115));
    pictureLabel.setMaximumSize(new Dimension(240, 115));
    pictureLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    pictureLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

    paidBox = new JTextField();
    paidBox.setMaximumSize(new Dimension(220, 28));
    paidBox.setAlignmentX(Component.CENTER_ALIGNMENT);

    subtotalLabel = new JLabel("Subtotal: $0.00");
    taxLabel = new JLabel("Tax: $0.00");
    totalLabel = new JLabel("Total: $0.00");
    changeLabel = new JLabel("Change: $0.00");

    subtotalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    taxLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    totalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    changeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

    JButton totalButton = new JButton("Total");
    JButton resetButton = new JButton("Reset");
    JButton exitButton = new JButton("Exit");

    totalButton.setMaximumSize(new Dimension(220, 35));
    totalButton.setAlignmentX(Component.CENTER_ALIGNMENT);

    totalButton.addActionListener(e -> calculateTotal());
    resetButton.addActionListener(e -> resetForm());
    exitButton.addActionListener(e -> System.exit(0));

    JPanel buttonPanel = new JPanel();
    buttonPanel.setMaximumSize(new Dimension(220, 40));
    buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
    buttonPanel.add(resetButton);
    buttonPanel.add(exitButton);

    JLabel amountLabel = new JLabel("Amount Paid:");
    amountLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

    panel.add(pictureLabel);
    panel.add(Box.createVerticalStrut(10));

    panel.add(amountLabel);
    panel.add(Box.createVerticalStrut(5));
    panel.add(paidBox);
    panel.add(Box.createVerticalStrut(15));

    panel.add(subtotalLabel);
    panel.add(Box.createVerticalStrut(10));
    panel.add(taxLabel);
    panel.add(Box.createVerticalStrut(10));
    panel.add(totalLabel);
    panel.add(Box.createVerticalStrut(10));
    panel.add(changeLabel);
    panel.add(Box.createVerticalStrut(15));

    panel.add(totalButton);
    panel.add(Box.createVerticalStrut(8));
    panel.add(buttonPanel);

    return panel;
}
    public JPanel makeExtrasPanel() {

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(210, 360));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Drinks and Shakes"));

        icedTea = new JCheckBox("Iced Tea");
        coffee = new JCheckBox("Coffee");
        orange = new JCheckBox("Orange");

        vanillaCone = new JCheckBox("Vanilla Cone");
        vanillaShake = new JCheckBox("Vanilla Shake");
        strawberryShake = new JCheckBox("Strawberry Shake");

        panel.add(new JLabel("Drinks $2.00"));
        panel.add(Box.createVerticalStrut(10));
        panel.add(icedTea);
        panel.add(Box.createVerticalStrut(10));
        panel.add(coffee);
        panel.add(Box.createVerticalStrut(10));
        panel.add(orange);

        panel.add(Box.createVerticalStrut(30));

        panel.add(new JLabel("Shakes $2.75"));
        panel.add(Box.createVerticalStrut(10));
        panel.add(vanillaCone);
        panel.add(Box.createVerticalStrut(10));
        panel.add(vanillaShake);
        panel.add(Box.createVerticalStrut(10));
        panel.add(strawberryShake);

        return panel;
    }

    public void addButtons() {

        fish.addActionListener(e -> {
            showPicture("fish.png");
            updateOrderBox();
        });

        chicken.addActionListener(e -> {
            showPicture("chicken.png");
            updateOrderBox();
        });

        turkey.addActionListener(e -> {
            showPicture("turkey.png");
            updateOrderBox();
        });

        burger.addActionListener(e -> {
            showPicture("burger.png");
            updateOrderBox();
        });

        fries.addActionListener(e -> updateOrderBox());
        salad.addActionListener(e -> updateOrderBox());
        onionRings.addActionListener(e -> updateOrderBox());

        icedTea.addActionListener(e -> updateOrderBox());
        coffee.addActionListener(e -> updateOrderBox());
        orange.addActionListener(e -> updateOrderBox());

        vanillaCone.addActionListener(e -> updateOrderBox());
        vanillaShake.addActionListener(e -> updateOrderBox());
        strawberryShake.addActionListener(e -> updateOrderBox());
    }

    public void showPicture(String fileName) {

        URL file = getClass().getResource("/images/" + fileName);

        if (file == null) {
            pictureLabel.setIcon(null);
            pictureLabel.setText("Missing image");
            return;
        }

        ImageIcon icon = new ImageIcon(file);

        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(220, 110, Image.SCALE_SMOOTH);

        pictureLabel.setIcon(new ImageIcon(newImage));
        pictureLabel.setText("");
    }

    public void updateOrderBox() {
        updateAmounts();

        orderBox.setText("");

        if (fish.isSelected()) {
            orderBox.append("Fish Sandwich\n");
        }

        if (chicken.isSelected()) {
            orderBox.append("Chicken Sandwich\n");
        }

        if (turkey.isSelected()) {
            orderBox.append("Turkey Sandwich\n");
        }

        if (burger.isSelected()) {
            orderBox.append("Burger\n");
        }

        if (fries.isSelected()) {
            orderBox.append("Fries\n");
        }

        if (salad.isSelected()) {
            orderBox.append("Salad\n");
        }

        if (onionRings.isSelected()) {
            orderBox.append("Onion Rings\n");
        }

        if (icedTea.isSelected()) {
            orderBox.append("Iced Tea\n");
        }

        if (coffee.isSelected()) {
            orderBox.append("Coffee\n");
        }

        if (orange.isSelected()) {
            orderBox.append("Orange\n");
        }

        if (vanillaCone.isSelected()) {
            orderBox.append("Vanilla Cone\n");
        }

        if (vanillaShake.isSelected()) {
            orderBox.append("Vanilla Shake\n");
        }

        if (strawberryShake.isSelected()) {
            orderBox.append("Strawberry Shake\n");
        }
    }

    private int subtotalCents() {
        int subtotal = 0;

        if (fish.isSelected() || chicken.isSelected() || turkey.isSelected() || burger.isSelected()) {
            subtotal += sandwichPrice;
        }

        if (fries.isSelected()) {
            subtotal += sidePrice;
        }

        if (salad.isSelected()) {
            subtotal += sidePrice;
        }

        if (onionRings.isSelected()) {
            subtotal += sidePrice;
        }

        if (icedTea.isSelected()) {
            subtotal += drinkPrice;
        }

        if (coffee.isSelected()) {
            subtotal += drinkPrice;
        }

        if (orange.isSelected()) {
            subtotal += drinkPrice;
        }

        if (vanillaCone.isSelected()) {
            subtotal += shakePrice;
        }

        if (vanillaShake.isSelected()) {
            subtotal += shakePrice;
        }

        if (strawberryShake.isSelected()) {
            subtotal += shakePrice;
        }

        return subtotal;
    }

    private int totalCents() {
        int subtotal = subtotalCents();
        return subtotal + (subtotal * 7 + 50) / 100; // 7% tax, rounded half-up to cents.
    }

    private String money(long cents) {
        return "$" + BigDecimal.valueOf(cents, 2).toPlainString();
    }

    private void invalidatePayment() {
        changeLabel.setText("Change: calculate after payment");
    }

    private void updateAmounts() {
        int subtotal = subtotalCents();
        int total = totalCents();
        subtotalLabel.setText("Subtotal: " + money(subtotal));
        taxLabel.setText("Tax: " + money(total - subtotal));
        totalLabel.setText("Total: " + money(total));
        invalidatePayment();
    }

    public void calculateTotal() {
        updateAmounts();
        String input = paidBox.getText().trim();
        if (!input.matches("[0-9]+(?:\\.[0-9]{1,2})?")) {
            JOptionPane.showMessageDialog(this, "Enter a nonnegative amount with up to two decimal places.");
            return;
        }
        long paid;
        try {
            paid = new BigDecimal(input).movePointRight(2).longValueExact();
            if (paid > 100000000L) throw new ArithmeticException("Payment limit");
        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(this, "Payment must be no more than $1,000,000.00.");
            return;
        }
        int total = totalCents();
        if (paid < total) {
            JOptionPane.showMessageDialog(this, "Insufficient payment. Amount due: " + money(total - paid));
            return;
        }
        changeLabel.setText("Change: " + money(paid - total));
    }

    public void resetForm() {

        chicken.setSelected(true);
        showPicture("chicken.png");

        fries.setSelected(false);
        salad.setSelected(false);
        onionRings.setSelected(false);

        icedTea.setSelected(false);
        coffee.setSelected(false);
        orange.setSelected(false);

        vanillaCone.setSelected(false);
        vanillaShake.setSelected(false);
        strawberryShake.setSelected(false);

        paidBox.setText("");

        subtotalLabel.setText("Subtotal: $0.00");
        taxLabel.setText("Tax: $0.00");
        totalLabel.setText("Total: $0.00");
        changeLabel.setText("Change: $0.00");

        updateOrderBox();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FastFoodRestaurant::new);
    }
}
