// https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1



class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] visited = new boolean[V];
        
        // Perform DFS from node 0 (assuming graph is 0-indexed)
        dfsUtil(0, adj, visited, dfs);
        
        return dfs;
    }
    private void dfsUtil(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> dfs) {
        visited[node] = true;
        dfs.add(node);
        
        // Visit all unvisited adjacent nodes
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfsUtil(neighbor, adj, visited, dfs);
            }
        }
    }
}