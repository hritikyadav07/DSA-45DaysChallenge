// https://leetcode.com/problems/valid-number/description/


class Solution {
    public boolean isNumber(String s) {
         s = s.trim();  // Remove leading and trailing spaces

        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenE = false;
        boolean seenSign = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                seenDigit = true;
                seenSign = false;  // Reset sign flag since digits can follow a sign
            } else if (c == '.') {
                if (seenDot || seenE) {
                    return false;
                }
                seenDot = true;
            } else if (c == 'e' || c == 'E') {
                if (seenE || !seenDigit) {
                    return false;
                }
                seenE = true;
                seenDigit = false;  // Reset digit flag to ensure there's a digit after 'e'
                seenSign = false;   // Reset sign flag to allow a sign after 'e'
            } else if (c == '+' || c == '-') {
                if (seenSign || (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')) {
                    return false;
                }
                seenSign = true;
                seenDigit = false;  // Reset digit flag to ensure there's a digit after the sign
            } else {
                return false;
            }
        }

        return seenDigit;
    }
}