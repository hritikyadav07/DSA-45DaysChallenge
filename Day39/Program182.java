// https://leetcode.com/problems/flood-fill/description/


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];
        if (originalColor != newColor) {
            dfs(image, sr, sc, originalColor, newColor);
        }
        return image;
    }
    
    // Depth-First Search to flood fill the image
    private void dfs(int[][] image, int sr, int sc, int color, int newColor) {
        // Boundary conditions: check if we are out of bounds or not on the target color
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) {
            return;
        }
        
        image[sr][sc] = newColor;  // Fill the current pixel with the new color
        
        // Recursively apply the new color to all four adjacent directions
        dfs(image, sr + 1, sc, color, newColor);  // Down
        dfs(image, sr - 1, sc, color, newColor);  // Up
        dfs(image, sr, sc + 1, color, newColor);  // Right
        dfs(image, sr, sc - 1, color, newColor);  // Left
    }
}
