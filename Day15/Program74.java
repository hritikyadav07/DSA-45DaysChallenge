// https://www.geeksforgeeks.org/problems/word-wrap1646/1


class Solution
{
    public int solveWordWrap (int[] nums, int k)
    {
        int n = nums.length;
        int[] dp = new int[n];
        int[] cost = new int[n];

        // Initialize dp array with a large value
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        // Base case: last word (no extra cost)
        dp[n - 1] = 0;

        // Calculate cost of each line starting from the last word
        for (int i = n - 2; i >= 0; i--) {
            int currLength = -1; // Start with -1 because there is no space before the first word
            for (int j = i; j < n; j++) {
                currLength += (nums[j] + 1); // Add word length and a space
                if (currLength <= k) {
                    if (j == n - 1) { // If it's the last word, no extra cost
                        cost[i] = 0;
                    } else {
                        cost[i] = (k - currLength) * (k - currLength);
                    }
                    dp[i] = Math.min(dp[i], cost[i] + (j + 1 < n ? dp[j + 1] : 0));
                } else {
                    break; // No more words can fit in this line
                }
            }
        }
        return dp[0];
    }
}