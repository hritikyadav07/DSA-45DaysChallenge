// https://leetcode.com/problems/evaluate-reverse-polish-notation/description/

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stk = new ArrayDeque<>();
        for (String ch : tokens) {
            if (ch.length() > 1) { // surely it is a number
                stk.push(Integer.parseInt(ch));
                continue;
            }
            if (Character.isDigit(ch.charAt(0))) {
                stk.push(Integer.parseInt(ch));
                continue;
            }
            int b = stk.pop();  // exp : a + b  RPN : a b +  STACK a b + 
            int a = stk.pop();  // therefore first b then a pops out
            if (ch.charAt(0) == '+')
                stk.push(a + b);

            else if (ch.charAt(0) == '-')
                stk.push(a - b);

            else if (ch.charAt(0) == '*')
                stk.push(a * b);

            else if (ch.charAt(0) == '/')
                stk.push(a / b);

        }
        return stk.pop();
    }
}