// 974. Subarray Sums Divisible by K
// https://leetcode.com/problems/subarray-sums-divisible-by-k/description/

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        int prefix =0;
        prefixSum.put(0,1);
        for(int num:nums){
            prefix += num;
            int mod = prefix%k;

            if(mod<0)
                mod+=k;

            if(prefixSum.containsKey(mod)){
                count+=prefixSum.get(mod);
                prefixSum.put(mod, prefixSum.getOrDefault(mod,0)+1);
            } else{
                prefixSum.put(mod,1);
            }
        }
        return count;
    }
}

