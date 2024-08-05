// https://leetcode.com/problems/find-peak-element/


class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n==1)return 0;
        int low = 0;
        int high = n-1;
        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid]>nums[mid+1]){
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return low;
    }
}