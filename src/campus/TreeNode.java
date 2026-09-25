package campus;

public class TreeNode {
    public Student student;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(Student student) {
        this.student = student;
        this.left = null;
        this.right = null;
    }
}