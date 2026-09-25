package campus;

public class HashTable {
    private static class HashNode {
        String key;
        Student value;
        HashNode next;

        public HashNode(String key, Student value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private HashNode[] buckets;
    private int capacity;
    private int size;

    public HashTable() {
        this(10);
    }

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.buckets = new HashNode[capacity];
        this.size = 0;
    }

    private int getBucketIndex(String key) {
        int hashCode = Math.abs(key.toLowerCase().hashCode());
        return hashCode % capacity;
    }

    public void insert(Student student) {
        if (student == null || student.getStudentId() == null) {
            System.out.println("Cannot insert null student or null student ID.");
            return;
        }

        String key = student.getStudentId().trim();
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];

        // Check if key already exists, update value
        while (head != null) {
            if (head.key.equalsIgnoreCase(key)) {
                head.value = student;
                System.out.println("Updated student record for ID: " + key);
                return;
            }
            head = head.next;
        }

        // Insert new node at the head of the chain
        size++;
        head = buckets[bucketIndex];
        HashNode newNode = new HashNode(key, student);
        newNode.next = head;
        buckets[bucketIndex] = newNode;
    }

    public Student search(String studentId) {
        if (studentId == null || studentId.trim().isEmpty()) {
            return null;
        }

        String key = studentId.trim();
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];

        while (head != null) {
            if (head.key.equalsIgnoreCase(key)) {
                return head.value;
            }
            head = head.next;
        }

        return null;
    }

    public boolean remove(String studentId) {
        if (studentId == null || studentId.trim().isEmpty()) {
            System.out.println("Invalid Student ID for removal.");
            return false;
        }

        String key = studentId.trim();
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        HashNode prev = null;

        while (head != null) {
            if (head.key.equalsIgnoreCase(key)) {
                break;
            }
            prev = head;
            head = head.next;
        }

        // Key was not present in Hash Table
        if (head == null) {
            System.out.println("Student ID " + key + " not found in Hash Table.");
            return false;
        }

        size--;

        // Remove node from chain
        if (prev != null) {
            prev.next = head.next;
        } else {
            buckets[bucketIndex] = head.next;
        }

        System.out.println("Successfully removed Student ID " + key + " from Hash Table.");
        return true;
    }

    public void display() {
        if (size == 0) {
            System.out.println("Hash Table is empty.");
            return;
        }

        System.out.println("--- Student Records (Hash Table Buckets) ---");
        for (int i = 0; i < capacity; i++) {
            HashNode head = buckets[i];
            if (head != null) {
                System.out.print("Bucket " + i + ": ");
                while (head != null) {
                    System.out.print("[" + head.value + "] -> ");
                    head = head.next;
                }
                System.out.println("null");
            }
        }
    }

    public int getSize() {
        return size;
    }
}