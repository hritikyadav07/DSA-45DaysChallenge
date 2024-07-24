// https://leetcode.com/problems/generate-parentheses/description/


class Solution {
    public void generate(List<String> result, int open, int close, String make){
        if(open==0 && close==0){
            result.add(make);
            return;
        }
        if(open>0){
            generate(result, open-1, close, make+"(");
        }
        if(close>open)
        generate(result, open, close-1, make+")");
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, n, n, "");
        return result;
    }
}