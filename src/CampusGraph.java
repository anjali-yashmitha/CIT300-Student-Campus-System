package campus;

import java.util.*;

public class CampusGraph {
    // Adjacency list to store graph: Location Name -> List of connected Location Names
    private Map<String, List<String>> adjList = new HashMap<>();

    // 1. Add Campus Location (Vertex) with error handling for duplicates
    public void addLocation(String locationName) {
        if (locationName == null || locationName.trim().isEmpty()) {
            System.out.println("Error: Location name cannot be empty.");
            return;
        }
        String trimmedName = locationName.trim();
        if (adjList.containsKey(trimmedName)) {
            System.out.println("Error: Location '" + trimmedName + "' already exists!");
            return;
        }
        adjList.put(trimmedName, new ArrayList<>());
        System.out.println("Success: Location '" + trimmedName + "' added.");
    }

    // 2. Remove Campus Location (Vertex) with error handling for missing locations
    public void removeLocation(String locationName) {
        if (locationName == null || !adjList.containsKey(locationName)) {
            System.out.println("Error: Location not found!");
            return;
        }
        for (String loc : adjList.keySet()) {
            adjList.get(loc).remove(locationName);
        }
        adjList.remove(locationName);
        System.out.println("Success: Location '" + locationName + "' and its connections removed.");
    }

    // 3. Add Campus Connection/Road (Edge - Undirected) with error handling
    public void addConnection(String loc1, String loc2) {
        if (!adjList.containsKey(loc1) || !adjList.containsKey(loc2)) {
            System.out.println("Error: One or both locations do not exist in the campus network!");
            return;
        }
        if (loc1.equals(loc2)) {
            System.out.println("Error: Cannot connect a location to itself.");
            return;
        }
        List<String> list1 = adjList.get(loc1);
        List<String> list2 = adjList.get(loc2);

        if (list1.contains(loc2)) {
            System.out.println("Error: Connection already exists between " + loc1 + " and " + loc2);
            return;
        }

        list1.add(loc2);
        list2.add(loc1); // Since roads are bidirectional
        System.out.println("Success: Road added between " + loc1 + " and " + loc2);
    }

    // 4. Remove Campus Connection/Road (Edge)
    public void removeConnection(String loc1, String loc2) {
        if (!adjList.containsKey(loc1) || !adjList.containsKey(loc2)) {
            System.out.println("Error: One or both locations do not exist!");
            return;
        }
        List<String> list1 = adjList.get(loc1);
        List<String> list2 = adjList.get(loc2);

        if (!list1.contains(loc2)) {
            System.out.println("Error: No connection exists between " + loc1 + " and " + loc2);
            return;
        }

        list1.remove(loc2);
        list2.remove(loc1);
        System.out.println("Success: Road removed between " + loc1 + " and " + loc2);
    }

    // 5. Display Campus Connections and Neighbours
    public void displayConnections() {
        if (adjList.isEmpty()) {
            System.out.println("Campus network is empty.");
            return;
        }
        System.out.println("\n--- Campus Network & Neighbours ---");
        for (Map.Entry<String, List<String>> entry : adjList.entrySet()) {
            System.out.println(entry.getKey() + " --> Connected to: " + entry.getValue());
        }
    }

    // 6. Breadth-First Search (BFS) Traversal
    public void bfsTraversal(String startLocation) {
        if (!adjList.containsKey(startLocation)) {
            System.out.println("Error: Start location not found in the campus network!");
            return;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(startLocation);
        queue.add(startLocation);

        System.out.print("\nBFS Traversal starting from " + startLocation + ": ");
        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");

            for (String neighbor : adjList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }
}