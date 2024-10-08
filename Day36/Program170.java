// https://leetcode.com/problems/maximum-product-subarray/description/


class Solution {
    public int maxProduct(int[] nums) {
        int l = nums.length;
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];
        int temp;
        for(int i = 1; i < l; i++){
            if(nums[i] < 0){
                temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(nums[i],nums[i]*max);
            min = Math.min(nums[i],nums[i]*min);
            ans = Math.max(ans,max);
        }
        return ans;
    }
}