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

    public void delete(String studentId) {
        if (studentId == null || studentId.trim().isEmpty()) {
            System.out.println("Invalid Student ID for deletion.");
            return;
        }
        root = deleteRecursive(root, studentId.trim());
    }

    private TreeNode deleteRecursive(TreeNode current, String studentId) {
        if (current == null) {
            System.out.println("Student ID " + studentId + " not found in BST.");
            return null;
        }

        int comparison = studentId.compareToIgnoreCase(current.student.getStudentId());

        if (comparison < 0) {
            current.left = deleteRecursive(current.left, studentId);
        } else if (comparison > 0) {
            current.right = deleteRecursive(current.right, studentId);
        } else {
            // Case 1: Leaf node (no children) or Case 2: One child
            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            }

            // Case 3: Node with two children
            // Find the smallest value in the right subtree (in-order successor)
            current.student = findMin(current.right);

            // Delete the in-order successor
            current.right = deleteRecursive(current.right, current.student.getStudentId());
        }

        return current;
    }

    private Student findMin(TreeNode current) {
        Student minStudent = current.student;
        while (current.left != null) {
            minStudent = current.left.student;
            current = current.left;
        }
        return minStudent;
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