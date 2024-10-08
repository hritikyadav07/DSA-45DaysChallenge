// https://leetcode.com/problems/permutations-ii/description/


class Solution { // Khandani backtracking with a bit of change
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> li = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>(); // to store the freq of unused elements
        for(int x : nums)
        map.put(x,map.getOrDefault(x,0)+1);

        helper(nums.length,li,map);
        return ans;
    }
    void helper(int l,List<Integer> li , HashMap<Integer,Integer>map){
        if(li.size() == l)
        {
            ans.add(new ArrayList<>(li));
            return;
        }

        for(int x : map.keySet()){
            if(map.get(x) == 0) continue; // alredy used leave it
            li.add(x);
            map.put(x,map.getOrDefault(x,1)-1); // try this
            helper(l,li,map);  // explore from here
            li.remove(li.size()-1); // revert back after trying
            map.put(x,map.getOrDefault(x,0)+1);
        }
    }
}