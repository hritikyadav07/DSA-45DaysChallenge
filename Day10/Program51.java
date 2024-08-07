// https://leetcode.com/problems/group-anagrams/


class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> groupAnagrams(String[] strs) {
        int l = strs.length;
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i = 0; i < l; i++){
            char ch[] = strs[i].toCharArray();
            Arrays.sort(ch);
            String sorted = String.valueOf(ch);
            if(!map.containsKey(sorted))
            map.put(sorted,new ArrayList<>());
            
            map.get(sorted).add(strs[i]);
        }
       // System.out.println(map.keySet());
         ans.addAll(map.values());
         return ans;
        
    }
}