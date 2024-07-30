// https://leetcode.com/problems/basic-calculator-ii/description/



class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        
        Deque<Integer> stk = new ArrayDeque<>();
        int num = 0;
        char sign = '+';
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            
            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                if (sign == '+') {
                    stk.push(num);
                } else if (sign == '-') {
                    stk.push(-num);
                } else if (sign == '*') {
                    stk.push(stk.pop() * num);
                } else if (sign == '/') {
                    stk.push(stk.pop() / num);
                }
                sign = ch;
                num = 0;
            }
        }
        
        int result = 0;
        while (!stk.isEmpty()) {
            result += stk.pop();
        }
        
        return result;
    }
}

