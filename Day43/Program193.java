// https://leetcode.com/problems/unique-paths/


class Solution { //memoization approach 
    int memo[][];
    public int traverse(int row, int col, int m, int n){
        if(row==m || col== n )return 0;
        if(row==m-1 && col== n-1)return 1;
        if(memo[row][col]!=0)return memo[row][col];

        memo[row][col] = traverse(row+1, col, m, n)+traverse(row, col+1, m, n);
        return memo[row][col];
    }
    public int uniquePaths(int m, int n) {
        memo= new int[m+1][n+1];
        return traverse(0,0,m,n);
    }
}