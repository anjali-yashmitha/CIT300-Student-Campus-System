package campus;

public class StudentLinkedList {
    private Node head;

    public StudentLinkedList() {
        head = null;
    }

    // Checks if the list has no students
    public boolean isEmpty() {
        return head == null;
    }

    // Checks if marks are within a valid range (0 to 100)
    public boolean isValidMarks(double marks) {
        return marks >= 0 && marks <= 100;
    }

    // Finds a student by ID. Returns null if not found.
    public Student findStudent(String id) {
        Node current = head;
        while (current != null) {
            if (current.data.getStudentId().equals(id)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    // Adds a student at the end. Returns false if the ID already exists,
    // or if the name is empty, or marks are invalid.
    public boolean addStudent(Student s) {
        if (s.getStudentId() == null || s.getStudentId().trim().isEmpty()) {
            System.out.println("Error: Student ID cannot be empty.");
            return false;
        }
        if (s.getName() == null || s.getName().trim().isEmpty()) {
            System.out.println("Error: Name cannot be empty.");
            return false;
        }
        if (!isValidMarks(s.getMarks())) {
            System.out.println("Error: Marks must be between 0 and 100.");
            return false;
        }
        if (findStudent(s.getStudentId()) != null) {
            System.out.println("Error: A student with this ID already exists.");
            return false;
        }
        Node newNode = new Node(s);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        return true;
    }

    // Updates an existing student's details. Returns false if not found or marks invalid.
    public boolean updateStudent(String id, String newName, String newProgramme, double newMarks) {
        Student s = findStudent(id);
        if (s == null) {
            System.out.println("Error: Student not found.");
            return false;
        }
        if (!isValidMarks(newMarks)) {
            System.out.println("Error: Marks must be between 0 and 100.");
            return false;
        }
        s.setName(newName);
        s.setProgramme(newProgramme);
        s.setMarks(newMarks);
        return true;
    }

    // Deletes a student by ID. Returns the deleted Student, or null if not found.
    public Student deleteStudent(String id) {
        if (head == null) {
            return null; // empty list
        }

        // Case 1: the student to delete is the first node
        if (head.data.getStudentId().equals(id)) {
            Student deleted = head.data;
            head = head.next;
            return deleted;
        }

        // Case 2: the student is somewhere after the first node
        Node current = head;
        while (current.next != null) {
            if (current.next.data.getStudentId().equals(id)) {
                Student deleted = current.next.data;
                current.next = current.next.next; // skip over the deleted node
                return deleted;
            }
            current = current.next;
        }

        return null; // not found
    }

    // Prints every student from first to last
    public void displayAll() {
        if (head == null) {
            System.out.println("No records available.");
            return;
        }
        Node current = head;
        int position = 1;
        while (current != null) {
            System.out.println(position + ". " + current.data);
            current = current.next;
            position++;
        }
    }
}