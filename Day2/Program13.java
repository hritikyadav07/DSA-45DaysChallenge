// https://leetcode.com/problems/3sum/description/

import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result= new ArrayList<>();
        int n=nums.length;
        for(int i = 0;i<n-1;i++){
            int j=i+1;
            int k = n-1;
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            while(j<k){
                int total =nums[i]+ nums[j]+nums[k];
                if(total == 0){
                   result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                while (nums[j] == nums[j-1] && j < k) {
                    j++;
                }
                } else if(total<0){
                    j++;
                } else{
                    k--;
                }
            }
        }
        return result;
    }
}