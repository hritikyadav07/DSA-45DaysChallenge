// https://leetcode.com/problems/valid-palindrome-ii/

class Solution {
    private boolean isPalindrome(StringBuilder s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return isPalindrome(new StringBuilder(s.substring(left + 1, right + 1))) ||
                       isPalindrome(new StringBuilder(s.substring(left, right)));
            }
        }
        
        return true;
    }
}