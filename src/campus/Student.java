package campus;

public class Student {
    private String studentId;
    private String name;
    private String programme;
    private double marks;

    // Constructor: runs when a new Student is created
    public Student(String studentId, String name, String programme, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.programme = programme;
        this.marks = marks;
    }

    // Getters: let other classes read the values
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getProgramme() {
        return programme;
    }

    public double getMarks() {
        return marks;
    }

    // Setters: let other classes update the values (no setter for studentId, it should not change)
    public void setName(String name) {
        this.name = name;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    // toString: controls how a Student prints when displayed
    @Override
    public String toString() {
        return "ID: " + studentId + " | Name: " + name
                + " | Programme: " + programme + " | Marks: " + marks;
    }
}