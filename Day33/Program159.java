// https://leetcode.com/problems/combination-sum-ii/


class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList());
        return ans;
    }
    public void backtrack(int[] cand, int target, int start, List<Integer> sub){
        if(target<0)return;
        if(target==0){
            ans.add(new ArrayList<>(sub));
            return;
        } 
        for(int i =start; i<cand.length;i++){
            if(i>start && cand[i]==cand[i-1])continue;
            sub.add(cand[i]);
            backtrack(cand,target-cand[i],i+1, sub);
            sub.remove(sub.size()-1);
        }
    }
}