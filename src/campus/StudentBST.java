package campus;

public class StudentBST {
    private TreeNode root;

    public StudentBST() {
        this.root = null;
    }

   
    public void insert(Student student) {
        if (student == null) {
            System.out.println("Cannot insert null student record.");
            return;
        }
        root = insertRecursive(root, student);
    }

    
    private TreeNode insertRecursive(TreeNode current, Student student) {
        if (current == null) {
            return new TreeNode(student);
        }

        
        int comparison = student.getStudentId().compareToIgnoreCase(current.student.getStudentId());

        if (comparison < 0) {
            current.left = insertRecursive(current.left, student);
        } else if (comparison > 0) {
            current.right = insertRecursive(current.right, student);
        } else {
            System.out.println("Student ID " + student.getStudentId() + " already exists in BST.");
        }

        return current;
    }

    
    public Student search(String studentId) {
        if (studentId == null || studentId.trim().isEmpty()) {
            return null;
        }
        return searchRecursive(root, studentId.trim());
    }

    
    private Student searchRecursive(TreeNode current, String studentId) {
        if (current == null) {
            return null;
        }

        int comparison = studentId.compareToIgnoreCase(current.student.getStudentId());

        if (comparison == 0) {
            return current.student;
        } else if (comparison < 0) {
            return searchRecursive(current.left, studentId);
        } else {
            return searchRecursive(current.right, studentId);
        }
    }

    
    public void displayInOrder() {
        if (root == null) {
            System.out.println("BST is empty. No student records found.");
            return;
        }
        System.out.println("--- Student Records (BST In-Order) ---");
        displayInOrderRecursive(root);
    }

    private void displayInOrderRecursive(TreeNode current) {
        if (current != null) {
            displayInOrderRecursive(current.left);
            System.out.println(current.student);
            displayInOrderRecursive(current.right);
        }
    }
}