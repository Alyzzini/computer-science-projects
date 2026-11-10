// Student Information Browser. See README.md for usage.
import javax.swing.SwingUtilities;

public class StudentInformationApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentInformationFrame frame = new StudentInformationFrame();
            frame.setVisible(true);
        });
    }
}
