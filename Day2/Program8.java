// https://leetcode.com/problems/two-sum/
import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> checked = new HashMap<>();
        int arr[] = new int[2];
        for(int i=0;i<nums.length;i++){
            int check = target- nums[i];
            if(checked.containsKey(check)){
                arr[0]=checked.get(check);
                arr[1] = i;
            } else {
                checked.put(nums[i], i);
            }
        }
        return arr;
    }
}
