package campus;

public class ActionHistoryStack {
    private ActionNode top;

    public ActionHistoryStack() {
        this.top = null;
    }

    public void push(String action) {
        ActionNode newNode = new ActionNode(action);
        newNode.next = top;
        top = newNode;
        System.out.println("Action pushed to stack successfully.");
    }

    public void pop() {
        if (top == null) {
            System.out.println("Stack is empty. No actions to pop.");
            return;
        }
        System.out.println("Popped action: " + top.actionDetails);
        top = top.next;
    }

    public void display() {
        if (top == null) {
            System.out.println("Action History Stack is empty.");
            return;
        }
        System.out.println("\n--- Action History Stack (LIFO) ---");
        ActionNode current = top;
        int count = 1;
        while (current != null) {
            System.out.println(count + ". " + current.actionDetails);
            current = current.next;
            count++;
        }
    }
}