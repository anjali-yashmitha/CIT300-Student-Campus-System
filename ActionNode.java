public class ActionNode {
    String actionDetails;
    ActionNode next;

    public ActionNode(String actionDetails) {
        this.actionDetails = actionDetails;
        this.next = null;
    }
}