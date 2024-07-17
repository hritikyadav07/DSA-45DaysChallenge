// https://leetcode.com/problems/find-all-duplicates-in-an-array/description/

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result =new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            if(set.contains(num)){
                result.add(num);
            } else{
                set.add(num);
            }
        }
        return result;
    }
}