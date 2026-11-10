// Student Information Browser. See README.md for usage.
public class Student {
    private final String studentId;
    private final String fullName;
    private final String course;
    private final String yearLevel;
    private final String section;
    private final String email;

    public Student(String studentId, String fullName, String course, String yearLevel, String section, String email) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.course = course;
        this.yearLevel = yearLevel;
        this.section = section;
        this.email = email;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCourse() {
        return course;
    }

    public String getYearLevel() {
        return yearLevel;
    }

    public String getSection() {
        return section;
    }

    public String getEmail() {
        return email;
    }
}
