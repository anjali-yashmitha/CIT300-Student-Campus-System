package campus;

public class StudentTreeNode {

    Student student;
    StudentTreeNode left;
    StudentTreeNode right;

    public StudentTreeNode(Student student) {
        this.student = student;
        this.left = null;
        this.right = null;
    }
}