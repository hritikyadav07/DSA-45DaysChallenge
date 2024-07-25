// https://leetcode.com/problems/backspace-string-compare/


class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder t1 = new StringBuilder();
        for(char c:s.toCharArray()){
            if(c=='#'){
                if(s1.length()>0)
                s1.delete(s1.length()-1, s1.length());
            } else {
                s1.append(c);
            }
        }
        for(char c:t.toCharArray()){
            if(c=='#'){
                if(t1.length()>0)
                t1.delete(t1.length()-1, t1.length());
            } else {
                t1.append(c);
            }
        }
        return s1.compareTo(t1)==0?true:false;
    }
}