package campus;

public class StudentHashTable {

    private Student[] table;
    private int size;

    public StudentHashTable(int size) {
        this.size = size;
        table = new Student[size];
    }

    
    private int hash(String studentId) {
        return Math.abs(studentId.hashCode()) % size;
    }

   
    public boolean insert(Student student) {

        int index = hash(student.getStudentId());

        int startIndex = index;

        while (table[index] != null) {

            if (table[index].getStudentId()
                    .equals(student.getStudentId())) {

                System.out.println("Error: Duplicate Student ID.");
                return false;
            }

            index = (index + 1) % size;

            if (index == startIndex) {
                System.out.println("Error: Hash table is full.");
                return false;
            }
        }

        table[index] = student;

        return true;
    }

    
    public Student search(String studentId) {

        int index = hash(studentId);

        int startIndex = index;

        while (table[index] != null) {

            if (table[index].getStudentId()
                    .equals(studentId)) {

                return table[index];
            }

            index = (index + 1) % size;

            if (index == startIndex) {
                break;
            }
        }

        return null;
    }

    
    public void display() {

        System.out.println("Hash Table:");

        for (int i = 0; i < size; i++) {

            if (table[i] != null) {
                System.out.println(
                    i + " -> " + table[i]
                );
            }
            else {
                System.out.println(
                    i + " -> Empty"
                );
            }
        }
    }
}