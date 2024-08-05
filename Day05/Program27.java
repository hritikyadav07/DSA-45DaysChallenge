// https://leetcode.com/problems/maximum-product-of-three-numbers/description/

class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n= nums.length-1;
        int mul1 = nums[n]*nums[n-1]*nums[n-2];
        int mul2 = nums[0]*nums[1]*nums[n];
        return Math.max(mul1, mul2);
    }
}