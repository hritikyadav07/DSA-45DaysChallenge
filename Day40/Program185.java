// https://leetcode.com/problems/decode-string/

class Solution {
    public int pos = 0;
    public String decodeString(String s) {
        int n = s.length();
        int repeat = 0;
        StringBuilder b = new StringBuilder();

        while(pos<n){
            char c = s.charAt(pos);
            if(c>='a' && c<='z'){
                b.append(c);
            }
            else if(c>='0' && c<='9'){
                repeat = repeat*10 + (c-'0');
            }
            else if(c == '['){
                pos++; //skip this count
                String str = decodeString(s);
                for(int i = 0; i<repeat ; i++){
                    b.append(str);
                }
                repeat = 0;
            }
            else if(c == ']'){
                break;
            }
            pos++;
        }
        return b.toString();
    }
}