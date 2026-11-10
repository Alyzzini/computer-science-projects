// Clothing Catalog Browser. See README.md for usage.
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ClothingStore extends JFrame {
    String[][] clothes = {
        {"EG82564", "converse sneaker", "L", "55.0", "images/sneaker.png"},
        {"VT6351", "ski jacket", "M", "350.0", "images/jacket.png"},
        {"SH1234", "black boots", "M", "80.0", "images/boots.png"},
        {"SH5678", "summer sandals", "S", "35.0", "images/sandals.png"}
    };

    int index = 0;

    JTextField itemID = new JTextField();
    JTextField name = new JTextField();
    JTextField size = new JTextField();
    JTextField price = new JTextField();

    JLabel imageLabel = new JLabel();

    public ClothingStore() {
        setTitle("Clothing Store");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        JLabel title = new JLabel("Clothing Store");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setForeground(Color.RED);
        title.setBounds(210, 20, 200, 30);
        add(title);

        addLabel("ItemID", 50, 80);
        addLabel("Name", 50, 120);
        addLabel("Size", 50, 160);
        addLabel("Price", 50, 200);

        itemID.setBounds(130, 80, 150, 25);
        name.setBounds(130, 120, 150, 25);
        size.setBounds(130, 160, 150, 25);
        price.setBounds(130, 200, 150, 25);

        itemID.setEditable(false);
        name.setEditable(false);
        size.setEditable(false);
        price.setEditable(false);

        add(itemID);
        add(name);
        add(size);
        add(price);

        imageLabel.setBounds(350, 80, 180, 160);
        add(imageLabel);

        JButton first = new JButton("First");
        JButton next = new JButton("Next");
        JButton prev = new JButton("Previous");
        JButton last = new JButton("Last");

        first.setBounds(60, 290, 80, 25);
        next.setBounds(260, 290, 80, 25);
        prev.setBounds(150, 290, 100, 25);
        last.setBounds(350, 290, 80, 25);

        add(first);
        add(next);
        add(prev);
        add(last);

        first.addActionListener(e -> {
            index = 0;
            displayRecord();
        });

        next.addActionListener(e -> {
            if (index == clothes.length - 1) {
                JOptionPane.showMessageDialog(null, "No more records to be displayed.");
            } else {
                index++;
                displayRecord();
            }
        });

        prev.addActionListener(e -> {
            if (index == 0) {
                JOptionPane.showMessageDialog(null, "No more records to be displayed.");
            } else {
                index--;
                displayRecord();
            }
        });

        last.addActionListener(e -> {
            index = clothes.length - 1;
            displayRecord();
        });

        displayRecord();
        setVisible(true);
    }

    public void addLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 70, 25);
        add(label);
    }

    public void displayRecord() {
        itemID.setText(clothes[index][0]);
        name.setText(clothes[index][1]);
        size.setText(clothes[index][2]);
        price.setText(clothes[index][3]);

        URL resource = getClass().getResource("/" + clothes[index][4]);
        if (resource == null) {
            imageLabel.setIcon(null);
            imageLabel.setText("Missing placeholder");
            return;
        }
        imageLabel.setText("");
        ImageIcon icon = new ImageIcon(resource);
        Image img = icon.getImage().getScaledInstance(180, 160, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(img));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ClothingStore::new);
    }
}
