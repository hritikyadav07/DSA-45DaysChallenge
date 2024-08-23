// https://leetcode.com/problems/number-of-islands/description/


class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Traverse through each cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {  // Start of a new island
                    numIslands++;  // Increment island count
                    dfs(grid, i, j);  // Mark all connected land as visited
                }
            }
        }
        
        return numIslands;
    }
    
    // Depth-First Search to mark all adjacent land
    private void dfs(char[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Boundary conditions: stop DFS if out of grid or on water
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0') {
            return;
        }
        
        grid[i][j] = '0';  // Mark current cell as visited by setting it to '0'
        
        // Explore all four directions (up, down, left, right)
        dfs(grid, i - 1, j);  // Up
        dfs(grid, i + 1, j);  // Down
        dfs(grid, j, j - 1);  // Left
        dfs(grid, i, j + 1);  // Right
    }
}
