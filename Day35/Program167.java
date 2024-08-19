// https://leetcode.com/problems/n-queens/description/

class Solution {
    public boolean isSafe(int row, int col, char[][] board){
        //horizontal
        for(int j=0;j<board.length;j++){
            if(board[row][j]=='Q')
            return false;
        }
        //vertical
        for(int i=0;i<board[0].length;i++){
            if(board[i][col]=='Q')
            return false;
        }
        //upperleft
        int r=row;
        for(int c=col;c>=0 &&r>=0;){
            if(board[r--][c--]=='Q')
            return false;
        }
        // upper right
        r=row;
        for(int c=col;c<board.length &&r>=0;){
            if(board[r--][c++]=='Q')
            return false;
        }
        //lower right
        r=row;
        for(int c=col;c<board.length &&r<board.length;r++,c++){
            if(board[r][c]=='Q')
            return false;
        }
        // lower left
        r=row;
        for(int c=col;c>=0 &&r<board.length;){
            if(board[r++][c--]=='Q')
            return false;
        }
        return true;
    }
    public void saveBoard(char[][] board, List<List<String>> allBoards){
        List<String> newboard = new LinkedList<>();
        for(int i=0;i<board.length;i++){
            String row="";
            for(char ch:board[i]){
                if(ch=='Q')
                row+='Q';
                else
                row+='.';
            }
            newboard.add(row);
        }
        allBoards.add(newboard);
    }
    public void helper(char[][] board, List<List<String>> allBoards, int col){
        if(col==board.length)
            saveBoard(board,allBoards);
        for(int row=0;row<board.length;row++){
            if(isSafe(row,col,board)){
                board[row][col]='Q';
                helper(board,allBoards,col+1);
                board[row][col]='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allBoards = new LinkedList<>();
        char[][] board = new char[n][n];

        helper(board,allBoards,0);
        return allBoards;
    }
}