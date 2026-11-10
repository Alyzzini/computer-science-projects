// Student Information Browser. See README.md for usage.
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class StudentInformationFrame extends JFrame {
    private final List<Student> students = new ArrayList<>();
    private int currentIndex = 0;

    private final JTextField txtStudentId = new JTextField(20);
    private final JTextField txtFullName = new JTextField(20);
    private final JTextField txtCourse = new JTextField(20);
    private final JTextField txtYearLevel = new JTextField(20);
    private final JTextField txtSection = new JTextField(20);
    private final JTextField txtEmail = new JTextField(20);
    private final JLabel lblStatus = new JLabel("Record 0 of 0", SwingConstants.CENTER);

    private final JButton btnFirst = new JButton("First");
    private final JButton btnPrevious = new JButton("Previous");
    private final JButton btnNext = new JButton("Next");
    private final JButton btnLast = new JButton("Last");

    public StudentInformationFrame() {
        setTitle("Student Information Management System");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        addSampleStudents();
        buildForm();
        buildButtons();
        setFieldsReadOnly();
        showStudent(currentIndex);
    }

    private void buildForm() {
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 5, 15));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        addRow(formPanel, gbc, 0, "Student ID:", txtStudentId);
        addRow(formPanel, gbc, 1, "Full Name:", txtFullName);
        addRow(formPanel, gbc, 2, "Course:", txtCourse);
        addRow(formPanel, gbc, 3, "Year Level:", txtYearLevel);
        addRow(formPanel, gbc, 4, "Section:", txtSection);
        addRow(formPanel, gbc, 5, "Email:", txtEmail);

        lblStatus.setFont(new Font("Arial", Font.BOLD, 14));

        add(formPanel, BorderLayout.CENTER);
        add(lblStatus, BorderLayout.NORTH);
    }

    private void addRow(JPanel panel, GridBagConstraints gbc, int row, String labelText, JTextField textField) {
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 0;
        panel.add(new JLabel(labelText), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        panel.add(textField, gbc);
    }

    private void buildButtons() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        btnFirst.addActionListener(e -> {
            currentIndex = 0;
            showStudent(currentIndex);
        });

        btnPrevious.addActionListener(e -> {
            if (currentIndex > 0) {
                currentIndex--;
                showStudent(currentIndex);
            }
        });

        btnNext.addActionListener(e -> {
            if (currentIndex < students.size() - 1) {
                currentIndex++;
                showStudent(currentIndex);
            }
        });

        btnLast.addActionListener(e -> {
            currentIndex = students.size() - 1;
            showStudent(currentIndex);
        });

        buttonPanel.add(btnFirst);
        buttonPanel.add(btnPrevious);
        buttonPanel.add(btnNext);
        buttonPanel.add(btnLast);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void setFieldsReadOnly() {
        txtStudentId.setEditable(false);
        txtFullName.setEditable(false);
        txtCourse.setEditable(false);
        txtYearLevel.setEditable(false);
        txtSection.setEditable(false);
        txtEmail.setEditable(false);
    }

    // replacement synthetic records; example.invalid addresses are deliberately non-deliverable.
    private void addSampleStudents() {
        students.add(new Student("DEMO-001", "Synthetic Student 01", "Computer Science", "1st Year", "CS-A", "student01@example.invalid"));
        students.add(new Student("DEMO-002", "Synthetic Student 02", "Information Technology", "2nd Year", "IT-B", "student02@example.invalid"));
        students.add(new Student("DEMO-003", "Synthetic Student 03", "Information Systems", "3rd Year", "IS-C", "student03@example.invalid"));
        students.add(new Student("DEMO-004", "Synthetic Student 04", "Computer Science", "4th Year", "CS-D", "student04@example.invalid"));
    }

    private void showStudent(int index) {
        if (students.isEmpty()) {
            currentIndex = 0;
            clearFields();
            lblStatus.setText("Record 0 of 0");
            setButtonState();
            return;
        }

        if (index < 0 || index >= students.size()) {
            throw new IllegalArgumentException("Student index outside collection");
        }
        Student student = students.get(index);
        txtStudentId.setText(student.getStudentId());
        txtFullName.setText(student.getFullName());
        txtCourse.setText(student.getCourse());
        txtYearLevel.setText(student.getYearLevel());
        txtSection.setText(student.getSection());
        txtEmail.setText(student.getEmail());

        lblStatus.setText("Record " + (index + 1) + " of " + students.size());
        setButtonState();
    }

    private void clearFields() {
        txtStudentId.setText("");
        txtFullName.setText("");
        txtCourse.setText("");
        txtYearLevel.setText("");
        txtSection.setText("");
        txtEmail.setText("");
    }

    private void setButtonState() {
        btnFirst.setEnabled(currentIndex > 0);
        btnPrevious.setEnabled(currentIndex > 0);
        btnNext.setEnabled(currentIndex < students.size() - 1);
        btnLast.setEnabled(currentIndex < students.size() - 1);
    }
}
