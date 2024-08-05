// https://leetcode.com/problems/majority-element/

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int elem = 0;
        for(int num:nums){
            if(count == 0){
                count=1;
                elem=num;
            } else if(num==elem)count++;
            else count--;
        }
        int count1=0;
        for(int i=0;i<nums.length;i++){
            if(elem==nums[i])count1++;
        }
        if(count1>Math.floor(nums.length/2))return elem;
        else return -1;
    }
}