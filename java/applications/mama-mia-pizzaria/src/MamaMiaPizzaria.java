// Mama Mia Pizzaria. See README.md for usage.
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.math.BigDecimal;

public class MamaMiaPizzaria {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> orderPizza());
    }

    private static void orderPizza() {
        int total = 0; // cents
        StringBuilder order = new StringBuilder("Mama Mia Pizzaria Order Summary\n\n");

        String[] sizes = {"Small", "Medium", "Large"};
        String size = (String) JOptionPane.showInputDialog(
                null,
                "Choose pizza size:",
                "Pizza Order",
                JOptionPane.QUESTION_MESSAGE,
                null,
                sizes,
                sizes[0]
        );

        if (size == null) {
            JOptionPane.showMessageDialog(null, "Order cancelled.");
            return;
        }

        switch (size) {
            case "Small":
                total += 899;
                break;
            case "Medium":
                total += 1099;
                break;
            case "Large":
                total += 1299;
                break;
        }

        order.append("Size: ").append(size).append("\n");

        int pepperoni = JOptionPane.showConfirmDialog(
                null, "Add Pepperoni for $1.50?", "Toppings", JOptionPane.YES_NO_OPTION);
        if (pepperoni == JOptionPane.CLOSED_OPTION) {
            JOptionPane.showMessageDialog(null, "Order cancelled.");
            return;
        }
        if (pepperoni == JOptionPane.YES_OPTION) {
            total += 150;
            order.append("Pepperoni: Yes\n");
        } else {
            order.append("Pepperoni: No\n");
        }

        int mushrooms = JOptionPane.showConfirmDialog(
                null, "Add Mushrooms for $1.00?", "Toppings", JOptionPane.YES_NO_OPTION);
        if (mushrooms == JOptionPane.CLOSED_OPTION) {
            JOptionPane.showMessageDialog(null, "Order cancelled.");
            return;
        }
        if (mushrooms == JOptionPane.YES_OPTION) {
            total += 100;
            order.append("Mushrooms: Yes\n");
        } else {
            order.append("Mushrooms: No\n");
        }

        int cheese = JOptionPane.showConfirmDialog(
                null, "Add Extra Cheese for $1.25?", "Toppings", JOptionPane.YES_NO_OPTION);
        if (cheese == JOptionPane.CLOSED_OPTION) {
            JOptionPane.showMessageDialog(null, "Order cancelled.");
            return;
        }
        if (cheese == JOptionPane.YES_OPTION) {
            total += 125;
            order.append("Extra Cheese: Yes\n");
        } else {
            order.append("Extra Cheese: No\n");
        }

        order.append("\nTotal Cost: $").append(BigDecimal.valueOf(total, 2).toPlainString());

        JOptionPane.showMessageDialog(null, order.toString(), "Order Total", JOptionPane.INFORMATION_MESSAGE);
    }
}
