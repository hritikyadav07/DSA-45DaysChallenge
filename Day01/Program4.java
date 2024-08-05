// 73. Set Matrix Zeroes
import java.util.HashSet;
class Solution {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        int m = matrix.length;
        int n= matrix[0].length;
        for(int i:rows){
            for(int j=0;j<n;j++){
                matrix[i][j]=0;
            }
        }
        for(int i:cols){
            for(int j=0;j<m;j++){
                matrix[j][i]=0;
            }
        }
    }
}