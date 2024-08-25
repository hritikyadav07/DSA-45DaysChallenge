// https://www.geeksforgeeks.org/problems/steps-by-knight5927/1


class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
     private static final int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static final int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    
    // Function to find minimum number of steps for the Knight to reach the target position
    public int minStepToReachTarget(int[] knightPos, int[] targetPos, int N) {
        // Convert the positions to 0-based index for easier handling
        int startX = knightPos[0] - 1;
        int startY = knightPos[1] - 1;
        int endX = targetPos[0] - 1;
        int endY = targetPos[1] - 1;
        
        // Check if the knight is already at the target position
        if (startX == endX && startY == endY) {
            return 0;
        }
        
        // Queue to store the positions and the number of steps taken
        Queue<int[]> queue = new LinkedList<>();
        // Visited array to avoid revisiting the same position
        boolean[][] visited = new boolean[N][N];
        
        // Enqueue the starting position with 0 steps
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;
        
        // BFS to find the shortest path
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int steps = current[2];
            
            // Explore all 8 possible moves
            for (int i = 0; i < 8; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                
                // Check if the new position is within bounds and not visited
                if (isValid(newX, newY, N) && !visited[newX][newY]) {
                    // If the knight reaches the target position, return the steps
                    if (newX == endX && newY == endY) {
                        return steps + 1;
                    }
                    
                    // Mark the position as visited and enqueue it
                    visited[newX][newY] = true;
                    queue.add(new int[]{newX, newY, steps + 1});
                }
            }
        }
        
        // If the target is unreachable (not possible given the problem constraints)
        return -1;
    }
    
    // Function to check if a position is within the chessboard bounds
    private boolean isValid(int x, int y, int N) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}