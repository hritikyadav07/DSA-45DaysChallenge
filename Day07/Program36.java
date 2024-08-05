// https://www.geeksforgeeks.org/problems/find-pair-given-difference1559/1

class Solution {
    public int findPair(int n, int x, int[] arr) {
        // code here
         int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int num : arr) {
            if (map.containsKey(num + x)) {
                count++;
            }
            if (map.containsKey(num - x)) {
                count++;
            }
            map.put(num, 1);
        }
        
        return count > 0 ?  1: -1;
    }
}