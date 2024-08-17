// https://leetcode.com/problems/subsets-ii/description/


class Solution {
    Set<List<Integer>> ans = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums,0,new ArrayList<>());
        return new ArrayList<>(ans);
    }
    public void backtrack(int[] nums, int start, List<Integer> sub){
        
        ans.add(new ArrayList<>(sub));
        for(int i =start; i<nums.length;i++){
            sub.add(nums[i]);
            backtrack(nums,i+1, sub);
            sub.remove(sub.size()-1);
        }
    }
}