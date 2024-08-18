// https://leetcode.com/problems/palindrome-partitioning/description/


class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(0, s, new ArrayList<String>());
        return result;
    }
    public void backtrack(int start, String s, List<String> temp){
        if(start==s.length()){
            result.add(new ArrayList(temp));
            return;
        }
    // Try partitioning the string at each possible position
        for (int end = start; end < s.length(); end++) {
            // Check if the current substring is a palindrome
            if (isPalindrome(s, start, end)) {
                // If it is, add it to the current partition and backtrack on the remaining substring
                temp.add(s.substring(start, end + 1));
                backtrack( end + 1, s, temp);
                // Backtrack: remove the last added substring to explore other partitions
                temp.remove(temp.size() - 1);
            }
        }
    }
    // Utility function to check if a substring is a palindrome
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}