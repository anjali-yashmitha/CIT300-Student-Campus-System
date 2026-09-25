package campus;

public class Member3Test {

    public static void main(String[] args) {

        StudentBST bst = new StudentBST();

        Student s1 = new Student(
                "S003",
                "Aisha",
                "Information Technology",
                85
        );

        Student s2 = new Student(
                "S001",
                "Sara",
                "Software Engineering",
                90
        );

        Student s3 = new Student(
                "S002",
                "Hana",
                "Computer Science",
                78
        );

        bst.insert(s1);
        bst.insert(s2);
        bst.insert(s3);

        System.out.println("=== BST STUDENTS ===");

        bst.displayStudents();

        System.out.println("\n=== BST SEARCH ===");

        Student result = bst.search("S002");

        if (result != null) {
            System.out.println("Student found:");
            System.out.println(result);
        }
        else {
            System.out.println("Student not found.");
        }
    }
}