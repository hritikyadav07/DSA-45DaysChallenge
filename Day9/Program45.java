// https://leetcode.com/problems/game-of-life/


class Solution {
    public int count(int[][] board, int r, int c, int m , int n){
        int count = 0;
        for(int i=r-1;i<=r+1;i++){
            for(int j = c-1;j<=c+1;j++){
                if(i==r && j==c){
                    continue;
                }
                if(i>-1 && j>-1 && i<m && j<n && board[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] newBoard = new int[m][n];
        for(int i = 0; i<m ; i++){
            for(int j = 0; j<n ; j++){
                int count = count(board, i, j,m,n);
                // System.out.println(count);
                if(board[i][j]==1){
                    if(count<2){
                        newBoard[i][j] = 0; 
                    } else if(count>3){
                        newBoard[i][j] = 0;
                    } else {
                        newBoard[i][j] = 1;
                    }
                } else {
                    if(count == 3){
                        newBoard[i][j] = 1;
                    } else{
                        newBoard[i][j] = 0;
                    }
                }
            }
        }
        for(int i = 0; i<m ; i++){
            for(int j = 0; j<n ; j++){
                board[i][j] = newBoard[i][j];
            }
        }
    }
}