// https://www.geeksforgeeks.org/problems/find-all-possible-palindromic-partitions-of-a-string/1


class Solution {
    public ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        backtrack(0, S, new ArrayList<String>());
        return result;
    }
    ArrayList<ArrayList<String>> result = new ArrayList<>();
    
    public void backtrack(int start, String s, ArrayList<String> temp){
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
    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
};