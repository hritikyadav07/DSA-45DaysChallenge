// https://www.geeksforgeeks.org/problems/rotten-oranges2536/1

class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // in case of empty input
        if(grid==null || grid.length==0){
            return -1;
        }
        
        int rows = grid.length;
        int cols = grid[0].length;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        
        // inserting all rotten oranges position in queue and counting fresh oranges
        for(int i = 0;i<rows;i++){
            for(int j=0;j<cols;j++){
               if(grid[i][j] == 2){
                   queue.offer(new int[]{i,j});
               } else if(grid[i][j] == 1){
                   fresh++;
               }
            }
        }
        //if there are no fresh oranges
        if(fresh==0)return -0;
        
        int time = 0;
        int direc[][] = {{-1,0},{1,0},{0,-1},{0,1}};
        
        //till no rotten gen oranges remain
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean rot =false;
            // remove 1st gen rotten oranges and add new gen rotten oranges
            for(int i = 0;i<size;i++){
                int current[] = queue.poll();
                int x = current[0];
                int y = current[1];
                // check in all four directions if there is oranges present that can rot
                for(int[]dir :direc){
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    
                    if(newX<0 ||newY<0 || newX>=rows ||newY>=cols || grid[newX][newY] != 1){
                        continue;
                    }
                    grid[newX][newY] = 2;
                    queue.offer(new int[]{newX, newY});
                    fresh--;
                    rot = true;
                }
            }
            if(rot) time++;
        }
        return fresh==0?time:-1;
    }
}