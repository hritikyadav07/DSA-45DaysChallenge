// https://leetcode.com/problems/distinct-subsequences/description/

class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        // dp array where dp[i][j] represents the number of distinct subsequences of
        // the first i characters of s that match the first j characters of t
        int[][] dp = new int[m + 1][n + 1];

        // Base case: an empty string t can be formed from any prefix of s in exactly one way
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        // Fill the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // The result is the number of distinct subsequences of s that match t
        return dp[m][n];
    }
}
