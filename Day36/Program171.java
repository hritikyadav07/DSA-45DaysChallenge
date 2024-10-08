// https://leetcode.com/problems/ones-and-zeroes/


class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int ans[][] = new int[m+1][n+1];

        for(String str : strs){
            int count0 = 0;
            int count1 = 0;
            for(char c : str.toCharArray()){
                if(c == '0')
                count0++;
                else
                count1++;
            }
            for(int i = m ; i >= count0; i--){
                for(int j = n; j >= count1; j--){
                    ans[i][j] = Math.max(ans[i][j],ans[i - count0][j - count1] + 1);
                }
            }
        }
        return ans[m][n];
    }
}