package campus;

public class ServiceRequestNode {
    String requestDetails;
    ServiceRequestNode next;

    public ServiceRequestNode(String requestDetails) {
        this.requestDetails = requestDetails;
        this.next = null;
    }
}