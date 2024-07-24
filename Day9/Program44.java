// https://leetcode.com/problems/jump-game/description/

class Solution {
    public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) {
                return false;
            }
            reachable = Math.max(reachable, i + nums[i]); //finding maximum place that i can reach i.e. from earlier jump or current jump
        }
        return true;
    }
}