// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/


class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> chara = new Stack<>();
        Stack<Integer> counta = new Stack<>();
        for(char ch:s.toCharArray()){
            if(chara.isEmpty()){
                chara.push(ch);
                counta.push(1);
            }
            else if(ch==chara.peek()){
                int count = counta.pop()+1;
                if(count==k){
                    while(count-->1){
                        chara.pop();
                    }
                } else{
                    counta.push(count);
                    chara.push(ch);
                }
            } else {
                chara.push(ch);
                counta.push(1);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!chara.isEmpty()){
            sb.append(chara.pop());
        }
        return sb.reverse().toString();
    }
}