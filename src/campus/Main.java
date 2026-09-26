package campus;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // One instance of each data structure, shared across the whole program
        StudentLinkedList studentList = new StudentLinkedList();
        ActionHistoryStack actionStack = new ActionHistoryStack();
        StudentServiceQueue serviceQueue = new StudentServiceQueue();
        StudentBST studentTree = new StudentBST();
        HashTable studentHashTable = new HashTable();
        CampusGraph campusGraph = new CampusGraph();

        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt(scanner, "Enter your choice: ");

            switch (choice) {
            case 1:
                System.out.print("Enter Student ID: ");
                String addId = scanner.nextLine().trim();
                System.out.print("Enter Name: ");
                String addName = scanner.nextLine().trim();
                System.out.print("Enter Programme: ");
                String addProgramme = scanner.nextLine().trim();
                double addMarks = readDouble(scanner, "Enter Marks: ");

                Student newStudent = new Student(addId, addName, addProgramme, addMarks);
                boolean added = studentList.addStudent(newStudent);

                if (added) {
                    studentTree.insert(newStudent);
                    studentHashTable.insert(newStudent);
                    actionStack.push("Added student: " + addId + " (" + addName + ")");
                    System.out.println("Student added successfully.");
                }
                break;
                   
            case 2:
                System.out.print("Enter Student ID to update: ");
                String updateId = scanner.nextLine().trim();
                System.out.print("Enter new Name: ");
                String updateName = scanner.nextLine().trim();
                System.out.print("Enter new Programme: ");
                String updateProgramme = scanner.nextLine().trim();
                double updateMarks = readDouble(scanner, "Enter new Marks: ");

                boolean updated = studentList.updateStudent(updateId, updateName, updateProgramme, updateMarks);

                if (updated) {
                    actionStack.push("Updated student: " + updateId);
                    System.out.println("Student updated successfully.");
                }
                break;
            case 3:
                System.out.print("Enter Student ID to delete: ");
                String deleteId = scanner.nextLine().trim();

                Student deletedStudent = studentList.deleteStudent(deleteId);

                if (deletedStudent != null) {
                    studentTree.delete(deleteId);
                    studentHashTable.remove(deleteId);
                    actionStack.push("Deleted student: " + deleteId + " (" + deletedStudent.getName() + ")");
                    System.out.println("Student deleted successfully: " + deletedStudent);
                } else {
                    System.out.println("Error: Student not found.");
                }
                break;
            case 4:
                studentList.displayAll();
                break;
            case 5:
                System.out.print("Enter service request details (e.g. Student ID and Service Type): ");
                String requestDetails = scanner.nextLine().trim();
                serviceQueue.enqueue(requestDetails);
                break;
            case 6:
                serviceQueue.dequeue();
                break;
            case 7:
                actionStack.display();
                break;
            case 8:
                studentTree.displayInOrder();
                break;
            case 9:
                System.out.print("Enter Student ID to search: ");
                String searchId = scanner.nextLine().trim();
                Student foundStudent = studentHashTable.search(searchId);

                if (foundStudent != null) {
                    System.out.println("Student found: " + foundStudent);
                } else {
                    System.out.println("Student not found.");
                }
                break;
            case 10:
                System.out.print("Enter new campus location name: ");
                String newLocation = scanner.nextLine().trim();
                campusGraph.addLocation(newLocation);
                break;
            case 11:
                System.out.print("Enter campus location name to remove: ");
                String removeLocation = scanner.nextLine().trim();
                campusGraph.removeLocation(removeLocation);
                break;
            case 12:
                System.out.print("Enter first location name: ");
                String connLoc1 = scanner.nextLine().trim();
                System.out.print("Enter second location name: ");
                String connLoc2 = scanner.nextLine().trim();
                campusGraph.addConnection(connLoc1, connLoc2);
                break;
            case 13:
                System.out.print("Enter first location name: ");
                String remConnLoc1 = scanner.nextLine().trim();
                System.out.print("Enter second location name: ");
                String remConnLoc2 = scanner.nextLine().trim();
                campusGraph.removeConnection(remConnLoc1, remConnLoc2);
                break;
            case 14:
                campusGraph.displayConnections();
                break;
            case 15:
                System.out.print("Enter starting location for BFS traversal: ");
                String bfsStart = scanner.nextLine().trim();
                campusGraph.bfsTraversal(bfsStart);
                break;
                case 16:
                    System.out.println("Exiting program. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 16.");
            }
        }

        scanner.close();
    }

    // Prints the main menu
    private static void printMenu() {
        System.out.println("\n===== University Student Record and Campus Route Management System =====");
        System.out.println("1. Add Student Record");
        System.out.println("2. Update Student Record");
        System.out.println("3. Delete Student Record");
        System.out.println("4. Display All Records using Linked List");
        System.out.println("5. Add Service Request to Queue");
        System.out.println("6. Process Next Service Request");
        System.out.println("7. Display Recent Actions using Stack");
        System.out.println("8. Display Students using BST");
        System.out.println("9. Search Student using Hashing");
        System.out.println("10. Add Campus Location");
        System.out.println("11. Remove Campus Location");
        System.out.println("12. Add Campus Connection/Road");
        System.out.println("13. Remove Campus Connection/Road");
        System.out.println("14. Display Campus Connections");
        System.out.println("15. Traverse Campus Locations using BFS");
        System.out.println("16. Exit");
    }

    // Safely reads an integer from the user, keeps asking if the input is invalid
    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    // Safely reads a double (for marks), keeps asking if the input is invalid
    private static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number for marks.");
            }
        }
    }
}