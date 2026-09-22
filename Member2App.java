
// 1. Service Request Node 
class ServiceRequestNode {
    int studentID;
    String studentName;
    String serviceType;
    ServiceRequestNode next;

    public ServiceRequestNode(int studentID, String studentName, String serviceType) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.serviceType = serviceType;
        this.next = null;
    }
}

// 2. Queue Implementation
class StudentServiceQueue {
    private ServiceRequestNode front, rear;

    public StudentServiceQueue() {
        front = rear = null;
    }

    public void enqueue(int studentID, String studentName, String serviceType) {
        ServiceRequestNode newNode = new ServiceRequestNode(studentID, studentName, serviceType);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println("Service request added to queue successfully!");
    }

    public void dequeue() {
        if (front == null) {
            System.out.println("Queue is empty! No service requests to process.");
            return;
        }
        System.out.println("Processing Service Request -> ID: " + front.studentID +
                " | Name: " + front.studentName + " | Service: " + front.serviceType);
        front = front.next;
        if (front == null) {
            rear = null;
        }
    }

    public void displayQueue() {
        if (front == null) {
            System.out.println("Service Queue is currently empty.");
            return;
        }
        System.out.println("\n--- Student Service Requests (Queue) ---");
        ServiceRequestNode current = front;
        int pos = 1;
        while (current != null) {
            System.out.println(pos + ". Student ID: " + current.studentID +
                    " | Name: " + current.studentName + " | Service: " + current.serviceType);
            current = current.next;
            pos++;
        }
    }
}

// 3. Action History Node (Stack සඳහා)
class ActionNode {
    String actionDescription;
    ActionNode next;

    public ActionNode(String actionDescription) {
        this.actionDescription = actionDescription;
        this.next = null;
    }
}

// 4. Stack Implementation
class ActionHistoryStack {
    private ActionNode top;

    public ActionHistoryStack() {
        top = null;
    }

    public void push(String actionDescription) {
        ActionNode newNode = new ActionNode(actionDescription);
        newNode.next = top;
        top = newNode;
    }

    public void pop() {
        if (top == null) {
            System.out.println("Stack is empty! No recent actions to undo.");
            return;
        }
        System.out.println("Undoing / Removing Recent Action: " + top.actionDescription);
        top = top.next;
    }

    public void displayStack() {
        if (top == null) {
            System.out.println("Action History Stack is currently empty.");
            return;
        }
        System.out.println("\n--- Recent Actions History (Stack) ---");
        ActionNode current = top;
        int pos = 1;
        while (current != null) {
            System.out.println(pos + ". " + current.actionDescription);
            current = current.next;
            pos++;
        }
    }
}

// 5. Test Application Class
public class Member2App {
    public static void main(String[] args) {
        StudentServiceQueue serviceQueue = new StudentServiceQueue();
        ActionHistoryStack actionStack = new ActionHistoryStack();

        serviceQueue.enqueue(1001, "Kamal", "Transcript Issue");
        serviceQueue.enqueue(1002, "Nimal", "ID Card Renewal");
        serviceQueue.displayQueue();

        actionStack.push("Added student record: Kamal");
        actionStack.push("Updated marks for student ID: 1002");
        actionStack.displayStack();

        System.out.println("\n--- Processing Queue & Stack Operations ---");
        serviceQueue.dequeue();
        actionStack.pop();

        System.out.println("\n--- After Processing ---");
        serviceQueue.displayQueue();
        actionStack.displayStack();
    }
}