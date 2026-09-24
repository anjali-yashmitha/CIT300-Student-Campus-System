package campus; 
 
import java.util.*; 
 
public class CampusGraph { 
    // 1. Change the adjacency list to store Location values     private Map<String, List<Location>> adjList = new HashMap<>(); 
 
    // 2. addLocation()     public void addLocation(String locationName) {         if (locationName == null || locationName.trim().isEmpty()) {             System.out.println("Error: Location name cannot be empty."); 
            return; 
        } 
        String trimmedName = locationName.trim();         if (adjList.containsKey(trimmedName)) { 
            System.out.println("Error: Location '" + trimmedName + "' already exists!"); 
            return; 
        } 
        adjList.put(trimmedName, new ArrayList<>()); 
        System.out.println("Success: Location '" + trimmedName + "' added."); 
    } 
 
    // 3. addConnection(), wrap names in Location objects     public void addConnection(String loc1, String loc2) {         if (!adjList.containsKey(loc1) || !adjList.containsKey(loc2)) {             System.out.println("Error: One or both locations do not exist in the campus network!"); 
            return; 
        } 
        if (loc1.equals(loc2)) { 
            System.out.println("Error: Cannot connect a location to itself."); 
            return; 
        } 
 
        List<Location> list1 = adjList.get(loc1);         List<Location> list2 = adjList.get(loc2); 
 
        boolean alreadyConnected = list1.stream().anyMatch(loc -> loc.getName().equals(loc2));         if (alreadyConnected) { 
            System.out.println("Error: Connection already exists between " + loc1 + " and " + loc2); 
            return; 
        } 
 
        list1.add(new Location(loc2));         list2.add(new Location(loc1)); 
        System.out.println("Success: Road added between " + loc1 + " and " + loc2); 
    } 
 
    // 4. removeLocation() and removeConnection()     public void removeLocation(String locationName) {         if (locationName == null || !adjList.containsKey(locationName)) { 
            System.out.println("Error: Location not found!"); 
            return; 
        } 
        for (String loc : adjList.keySet()) {             adjList.get(loc).removeIf(l -> l.getName().equals(locationName)); 
        } 
        adjList.remove(locationName); 
        System.out.println("Success: Location " + locationName + " and its connections removed."); 
    } 
 
    public void removeConnection(String loc1, String loc2) {         if (!adjList.containsKey(loc1) || !adjList.containsKey(loc2)) {             System.out.println("Error: One or both locations do not exist!"); 
            return; 
        } 
 
        List<Location> list1 = adjList.get(loc1);         List<Location> list2 = adjList.get(loc2); 
 
        boolean connected = list1.stream().anyMatch(l -> l.getName().equals(loc2));         if (!connected) { 
            System.out.println("Error: No connection exists between " + loc1 + " and " + loc2); 
            return; 
        } 
 
        list1.removeIf(l -> l.getName().equals(loc2));         list2.removeIf(l -> l.getName().equals(loc1));         System.out.println("Success: Road removed between " + loc1 + " and " + loc2); 
    } 
 
    // 5. displayConnections()     public void displayConnections() {         if (adjList.isEmpty()) { 
            System.out.println("Campus network is empty."); 
            return; 
        } 
        System.out.println("\n--- Campus Network Connections ---");         for (Map.Entry<String, List<Location>> entry : adjList.entrySet()) { 
            System.out.print(entry.getKey() + " -> ");             List<Location> neighbors = entry.getValue();             for (int i = 0; i < neighbors.size(); i++) {                 System.out.print(neighbors.get(i));                 if (i < neighbors.size() - 1) { 
                    System.out.print(", "); 
                } 
            } 
            System.out.println(); 
        } 
    } 
 
    // 6. bfsTraversal()     public void bfsTraversal(String startLocation) {         if (!adjList.containsKey(startLocation)) {             System.out.println("Error: Start location not found in the campus network!"); 
            return; 
        } 
 
        Set<String> visited = new HashSet<>(); 
        Queue<String> queue = new LinkedList<>(); 
 
        visited.add(startLocation);         queue.add(startLocation); 
 
        System.out.print("\nBFS Traversal starting from " + startLocation + ": "); 
 
        while (!queue.isEmpty()) { 
            String current = queue.poll(); 
            System.out.print(current + " "); 
 
            for (Location neighbor : adjList.get(current)) {                 if (!visited.contains(neighbor.getName())) {                     visited.add(neighbor.getName());                     queue.add(neighbor.getName()); 
                } 
            } 
        } 
        System.out.println(); 
    } 
} 
