// https://leetcode.com/problems/valid-parentheses/description/

import java.util.Stack;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> parent = new Stack<>();
        for(char ch:s.toCharArray()){
            if( ch=='(' || ch=='{' || ch=='['){
                parent.push(ch);
            }else if(!parent.isEmpty() && ch==')' && parent.peek()=='('){
                parent.pop();
            }else if(!parent.isEmpty() && ch=='}' && parent.peek()=='{'){
                parent.pop();
            }else if(!parent.isEmpty() && ch==']' && parent.peek()=='['){
                parent.pop();
            } else {
                parent.push(ch);
            }
        }
        return parent.isEmpty();
    }
}