package campus;

public class StudentBST {

    private StudentTreeNode root;

    public StudentBST() {
        root = null;
    }

    
    public void insert(Student student) {
        root = insertRecursive(root, student);
    }

    private StudentTreeNode insertRecursive(StudentTreeNode current, Student student) {

        if (current == null) {
            return new StudentTreeNode(student);
        }

        int comparison = student.getStudentId()
                .compareTo(current.student.getStudentId());

        if (comparison < 0) {
            current.left = insertRecursive(current.left, student);
        }
        else if (comparison > 0) {
            current.right = insertRecursive(current.right, student);
        }
        else {
            System.out.println("Error: Duplicate Student ID.");
        }

        return current;
    }

    
    public void displayStudents() {

        if (root == null) {
            System.out.println("No students in BST.");
            return;
        }

        inOrder(root);
    }

    private void inOrder(StudentTreeNode current) {

        if (current != null) {

            inOrder(current.left);

            System.out.println(current.student);

            inOrder(current.right);
        }
    }

    
    public Student search(String studentId) {

        StudentTreeNode current = root;

        while (current != null) {

            int comparison = studentId
                    .compareTo(current.student.getStudentId());

            if (comparison == 0) {
                return current.student;
            }

            if (comparison < 0) {
                current = current.left;
            }
            else {
                current = current.right;
            }
        }

        return null;
    }
}