// https://leetcode.com/problems/word-search/description/

class Solution {
    
    // int[][] moves = {{0,-1}, {0,1}, {-1,0}, {1,0}};
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]==word.charAt(0) && find(board, word, i, j, 0, row, col)){
                    return true;
                }
            }
        }
        return false;
    }
    boolean find(char[][] board, String word, int r, int c, int ind, int row, int col){
        if(ind == word.length()){
            return true;
        }

        if(r>=row || c>=col || r<0 || c<0 || board[r][c]=='#'){
            return false;
        } // if pointers on matrix go out of bounds
        if(board[r][c]!=word.charAt(ind)){
            return false;
        }
        char save = board[r][c];
        board[r][c] = '#';
        int moves[][] = {{0,-1},{1,0},{0,1},{-1,0}};
        for(int m =0;m<moves.length;m++){
            int newr = r + moves[m][0];
            int newc = c + moves[m][1];
            if(find(board, word, newr, newc, ind+1, row, col))
            return true;
        }
        board[r][c] = save;
        return false;
        
    }
}