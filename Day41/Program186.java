// https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // Visited array to track visited nodes
        boolean[] visited = new boolean[V];
        // Recursion stack to track nodes in the current DFS call
        boolean[] recStack = new boolean[V];
        
        // Check for a cycle in each disconnected component
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCyclicUtil(i, adj, visited, recStack)) {
                    return true; // Cycle found
                }
            }
        }
        return false; // No cycle found
    }

    // Utility function for DFS traversal and cycle detection
    private boolean isCyclicUtil(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] recStack) {
        // Mark the current node as visited and add it to the recursion stack
        visited[node] = true;
        recStack[node] = true;

        // Visit all the neighbors of the current node
        for (Integer neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                // Recursively visit the neighbor
                if (isCyclicUtil(neighbor, adj, visited, recStack)) {
                    return true; // Cycle found
                }
            } else if (recStack[neighbor]) {
                // If the neighbor is already in the recursion stack, a cycle is detected
                return true;
            }
        }

        // Remove the node from the recursion stack before returning
        recStack[node] = false;
        return false;
    }

}