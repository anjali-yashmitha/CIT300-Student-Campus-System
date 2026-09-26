# CIT300 Student Record and Campus Route Management System

A Java console application developed for the CIT300 Data Structures and Algorithms Graded Practical Assignment 1. The system manages university student records and represents connections between campus locations, demonstrating the practical use of linked lists, stacks, queues, trees, hashing, and graphs.

## Group Members

| Name | Student ID | Responsibility | Branch |
|---|---|---|---|
| C.H.M.A.Y.K. Monarawila | 23DA2-0212 | Member 1: Student records and linked list implementation (Student, Node, StudentLinkedList) | member1-linkedlist |
| G.M.H.P. Karunarathna | 23DA2-0193 | Member 2: Stack and queue implementation (ActionHistoryStack, ActionNode, StudentServiceQueue, ServiceRequestNode) | member2-stack-queue |
| Thawoos Fathima Sajiya Bee | 23DA2-0446 | Member 3: BST and hashing implementation (StudentBST, TreeNode, HashTable) | member-3-bst-hashing |
| B.M. Navoda Harshani Bannaka | 23DA2-0219 | Member 4: Graph implementation, campus locations, connections, and BFS traversal (CampusGraph, Location) | member4-graph |

All members contributed to integration, validation, testing, debugging, and the shared `Main.java`, and to this documentation.
## System Overview

The application provides a menu-driven console interface with the following features:

1. Add Student Record
2. Update Student Record
3. Delete Student Record
4. Display All Records using Linked List
5. Add Service Request to Queue
6. Process Next Service Request
7. Display Recent Actions using Stack
8. Display Students using BST
9. Search Student using Hashing
10. Add Campus Location
11. Remove Campus Location
12. Add Campus Connection/Road
13. Remove Campus Connection/Road
14. Display Campus Connections
15. Traverse Campus Locations using BFS
16. Exit

## Data Structures Used

| Data Structure | Used For | Class(es) |
|---|---|---|
| Linked List | Storing and managing student records | `StudentLinkedList`, `Node` |
| Stack | Tracking recent actions (add/delete) | `ActionHistoryStack`, `ActionNode` |
| Queue | Managing student service requests in order of arrival | `StudentServiceQueue`, `ServiceRequestNode` |
| Binary Search Tree | Organizing and displaying student records by Student ID | `StudentBST`, `TreeNode` |
| Hash Table | Fast student lookup by Student ID | `HashTable` |
| Graph (Adjacency List) | Representing campus locations and connections | `CampusGraph`, `Location` |
## Project Structure

src/campus/
├── Main.java (shared menu, integrates all components)
├── Student.java
├── Node.java
├── StudentLinkedList.java
├── ActionNode.java
├── ActionHistoryStack.java
├── ServiceRequestNode.java
├── StudentServiceQueue.java
├── TreeNode.java
├── StudentBST.java
├── HashTable.java
├── Location.java
└── CampusGraph.java

## How to Run

1. Clone the repository
2. Open the project in Eclipse (or any Java IDE)
3. Run `Main.java` as a Java Application
4. Follow the on-screen menu prompts

## Validation and Error Handling

The system validates:
- Empty or missing Student ID, Name, or Programme
- Marks outside the 0-100 range
- Duplicate Student IDs and duplicate campus locations
- Operations on non-existent students or locations
- Invalid or non-numeric menu input
