// https://leetcode.com/problems/minimum-path-sum/description/


class Solution {
    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c =  grid[0].length;
        int dp[][] = new int[r][c]; // 2-D dp mata
        return dfs(grid,0,0,dp);
    }
     public int dfs(int [][]grid , int i , int j , int[][]dp)
{
    int r = grid.length;
    int c = grid[0].length;

    if(i == r - 1 && j == c - 1)
    return grid[i][j];

    if(dp[i][j] != 0)
    return dp[i][j];

    int right = Integer.MAX_VALUE;
    int down = Integer.MAX_VALUE;

    if(j + 1 < c)
    right = dfs(grid, i , j+1 , dp);

    if(i + 1 < r)
    down = dfs(grid,i+1,j,dp);

    dp[i][j] = grid[i][j] + Math.min(right,down);
    return dp[i][j];
}
}