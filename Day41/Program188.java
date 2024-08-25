// https://leetcode.com/problems/shortest-bridge/description/

class Solution {
    private static final int[] dx = {-1, 0, 1, 0}; // Direction vectors for row
    private static final int[] dy = {0, -1, 0, 1}; // Direction vectors for column

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        
        // Step 1: Find the first island and mark it
        boolean found = false;
        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < n && !found; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, visited, queue);
                    found = true;
                }
            }
        }
        
        // Step 2: BFS to find the shortest path to the second island
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                
                for (int d = 0; d < 4; d++) {
                    int newX = x + dx[d];
                    int newY = y + dy[d];
                    
                    if (isValid(newX, newY, n) && !visited[newX][newY]) {
                        if (grid[newX][newY] == 1) {
                            return steps;
                        }
                        queue.add(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
            steps++;
        }
        
        return -1; // should not reach here
    }
    
    // DFS to mark the first island and add its coordinates to the queue
    private void dfs(int[][] grid, int x, int y, boolean[][] visited, Queue<int[]> queue) {
        int n = grid.length;
        if (x < 0 || y < 0 || x >= n || y >= n || visited[x][y] || grid[x][y] == 0) {
            return;
        }
        visited[x][y] = true;
        queue.add(new int[]{x, y});
        
        for (int d = 0; d < 4; d++) {
            dfs(grid, x + dx[d], y + dy[d], visited, queue);
        }
    }
    
    // Check if the new coordinates are within the grid bounds
    private boolean isValid(int x, int y, int n) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}