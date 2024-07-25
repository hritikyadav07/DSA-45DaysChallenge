// https://leetcode.com/problems/reverse-words-in-a-string/description/

class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        // s.trim();
        String [] str = s.split(" ");
        for (int i = 0; i < str.length / 2; i++) {
            String temp = str[i];
            str[i] = str[str.length - 1 - i];
            str[str.length - 1 - i] = temp;
        }
        String ans = "";
        for(String r:str){
            if(r!="")
            sb.append(r+" ");
        }
        ans = sb.toString();
        ans = ans.trim(); 
        return ans;
    }
}