// https://leetcode.com/problems/combinations/description/

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(n,k,1,new ArrayList<>());
        return ans;
    }
    public void backtrack(int n, int k, int start, List<Integer> sub){
        if(sub.size()==k){
            ans.add(new ArrayList<>(sub));
            return;
        } 
        for(int i =start; i<=n;i++){
            sub.add(i);
            backtrack(n,k,i+1, sub);
            sub.remove(sub.size()-1);
        }
    }
}