package campus;

public class HashTable {
    
    private static class HashNode {
        Student student;
        HashNode next;

        public HashNode(Student student) {
            this.student = student;
            this.next = null;
        }
    }

    private static final int INITIAL_CAPACITY = 11; 
    private HashNode[] table;
    private int size;

    public HashTable() {
        this.table = new HashNode[INITIAL_CAPACITY];
        this.size = 0;
    }

    
    private int hashFunction(String studentId) {
        int hash = 0;
        for (int i = 0; i < studentId.length(); i++) {
            hash = (31 * hash + studentId.charAt(i)) % table.length;
        }
        return Math.abs(hash);
    }

    
    public void insert(Student student) {
        if (student == null || student.getStudentId() == null) {
            System.out.println("Cannot insert invalid student record into HashTable.");
            return;
        }

        int index = hashFunction(student.getStudentId());
        HashNode head = table[index];

        
        HashNode current = head;
        while (current != null) {
            if (current.student.getStudentId().equalsIgnoreCase(student.getStudentId())) {
                System.out.println("Student ID " + student.getStudentId() + " already exists in HashTable.");
                return;
            }
            current = current.next;
        }

        
        HashNode newNode = new HashNode(student);
        newNode.next = head;
        table[index] = newNode;
        size++;
    }

    
    public Student search(String studentId) {
        if (studentId == null || studentId.trim().isEmpty()) {
            return null;
        }

        int index = hashFunction(studentId.trim());
        HashNode current = table[index];

        while (current != null) {
            if (current.student.getStudentId().equalsIgnoreCase(studentId.trim())) {
                return current.student;
            }
            current = current.next;
        }

        return null; 
    }

        public void displayAll() {
        if (size == 0) {
            System.out.println("HashTable is empty.");
            return;
        }

        System.out.println("--- Student Records (HashTable) ---");
        for (int i = 0; i < table.length; i++) {
            HashNode current = table[i];
            while (current != null) {
                System.out.println("[Bucket " + i + "] " + current.student);
                current = current.next;
            }
        }
    }
}