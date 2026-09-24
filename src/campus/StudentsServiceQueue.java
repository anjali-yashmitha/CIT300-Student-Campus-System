package campus;

public class StudentsServiceQueue {
    private ServiceRequestNode front, rear;

    public StudentsServiceQueue() {
        this.front = this.rear = null;
    }

    public void enqueue(String request) {
        ServiceRequestNode newNode = new ServiceRequestNode(request);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println("Service request added to queue.");
    }

    public void dequeue() {
        if (front == null) {
            System.out.println("Queue is empty. No service requests to process.");
            return;
        }
        System.out.println("Processing and removing request: " + front.requestDetails);
        front = front.next;
        if (front == null) {
            rear = null;
        }
    }

    public void display() {
        if (front == null) {
            System.out.println("Students Service Queue is empty.");
            return;
        }
        System.out.println("\n--- Students Service Queue (FIFO) ---");
        ServiceRequestNode current = front;
        int count = 1;
        while (current != null) {
            System.out.println(count + ". " + current.requestDetails);
            current = current.next;
            count++;
        }
    }
}