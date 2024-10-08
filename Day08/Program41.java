// https://leetcode.com/problems/subsets/description/


class Solution {
    List<List<Integer>> superSet = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
    List<Integer> li = new ArrayList<>();
      backtracking(nums,0,li);
      return superSet;  
    }
    void backtracking(int[]nums ,int indx,List<Integer> li){
        //base case
        if(indx == nums.length)
        {   if(!superSet.contains(li))
            superSet.add(new ArrayList<>(li));
            return;
        }

        for(int i = indx; i < nums.length; i++){
            li.add(nums[i]);
            backtracking(nums,i+1,li);
            li.remove(li.size()-1);
            backtracking(nums,i+1,li);
        }
    }
}