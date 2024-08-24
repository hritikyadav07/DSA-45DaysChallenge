// https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1


class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> paths = new ArrayList<>();
        int n = mat.length;
        
        // Edge case: if the starting or ending point is blocked
        if (mat[0][0] == 0 || mat[n - 1][n - 1] == 0) {
            return paths;
        }
        
        boolean[][] visited = new boolean[n][n];
        backtrack(mat, 0, 0, n, "", paths, visited);
        return paths;
    }
    
    private void backtrack(int[][] mat, int i, int j, int n, String path, ArrayList<String> paths, boolean[][] visited) {
        // Base case: reached the destination
        if (i == n - 1 && j == n - 1) {
            paths.add(path);
            return;
        }
        
        // Mark the current cell as visited
        visited[i][j] = true;
        
        // Move Down
        if (isSafe(mat, i + 1, j, n, visited)) {
            backtrack(mat, i + 1, j, n, path + 'D', paths, visited);
        }
        
        // Move Left
        if (isSafe(mat, i, j - 1, n, visited)) {
            backtrack(mat, i, j - 1, n, path + 'L', paths, visited);
        }
        
        // Move Right
        if (isSafe(mat, i, j + 1, n, visited)) {
            backtrack(mat, i, j + 1, n, path + 'R', paths, visited);
        }
        
        // Move Up
        if (isSafe(mat, i - 1, j, n, visited)) {
            backtrack(mat, i - 1, j, n, path + 'U', paths, visited);
        }
        
        // Backtrack: unmark the current cell as visited
        visited[i][j] = false;
    }
    
    private boolean isSafe(int[][] mat, int i, int j, int n, boolean[][] visited) {
        return (i >= 0 && i < n && j >= 0 && j < n && mat[i][j] == 1 && !visited[i][j]);
    }
}