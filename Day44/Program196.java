// https://www.geeksforgeeks.org/problems/longest-common-substring1452/1

class Solution {
    public int longestCommonSubstr(String str1, String str2) {
        // code here
        int n = str1.length();
        int t = str2.length();
        int [][] dp = new int[n+1][t+1];
        for(int i= 0;i<=n;i++) dp[i][0] = 0 ;
        for(int j= 0;j<=t;j++) dp[0][j] = 0 ;
        int ans = 0;
        for(int i = 1 ; i<=n;i++){
            for(int j=1;j<=t;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                    ans = Math.max(dp[i][j], ans);
                }
                else dp[i][j]=0;
            }
        }
        return ans;
    }
}