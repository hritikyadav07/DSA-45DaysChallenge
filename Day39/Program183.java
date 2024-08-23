// https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
      boolean[] visited = new boolean[V];
        
        // Start DFS from every unvisited node
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(adj, i, visited, -1)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    private boolean dfs(ArrayList<ArrayList<Integer>> graph, int node, boolean[] visited, int parent) {
        visited[node] = true;
        
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(graph, neighbor, visited, node)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true; // A cycle is detected
            }
        }
        
        return false;
    }
}