// https://leetcode.com/problems/coin-change/description/


class Solution {
    public int coinChange(int[] coins, int amount) {
        //intialize dp array for all amounts from 0 to amount
        int[] dp = new int[amount+1];
        //fill dp with impossible value which will not be reached
        Arrays.fill(dp, amount+1);
        dp[0] = 0; // base case

        for(int coin : coins){
            // using this coin which amount can be fulfilled with minimum coins
            for(int i = coin ;i<=amount;i++){
                dp[i] = Math.min(dp[i], dp[i-coin]+1);
                // dp[i-coin] = minimum coins to reach thqat value+ add one more coin
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }
}