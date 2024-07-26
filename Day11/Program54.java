// https://www.geeksforgeeks.org/problems/print-anagrams-together/1

class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
        // Code here
        List<List<String>> ans = new ArrayList<>();
        int l = string_list.length;
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i = 0; i < l; i++){
            char ch[] = string_list[i].toCharArray();
            Arrays.sort(ch);
            String sorted = String.valueOf(ch);
            if(!map.containsKey(sorted))
            map.put(sorted,new ArrayList<>());
            
            map.get(sorted).add(string_list[i]);
        }
       // System.out.println(map.keySet());
         ans.addAll(map.values());
         return ans;
    }
}