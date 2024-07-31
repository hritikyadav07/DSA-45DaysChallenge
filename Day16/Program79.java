// https://leetcode.com/problems/text-justification/description/

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int index = 0;

        while(index<n){
            int totalChars = words[index].length();
            int last = index+1;
            while(last<n){
                if(totalChars + 1 + words[last].length() >maxWidth) break;
                totalChars = totalChars + 1 + words[last].length();
                last++;
            }
            StringBuilder sb = new StringBuilder();
            int numOfWords = last - index;
            int numOfSpaces = maxWidth - totalChars;

            if(last==n || numOfWords==1){
                for(int i = index;i<last;i++){
                    sb.append(words[i]);
                    if (i != last - 1) sb.append(" ");
                }
                int spaces = maxWidth - sb.length();
                while(spaces-->0){
                    sb.append(" ");
                }
            } else {
                int spacesBetween = numOfSpaces / (numOfWords -1);
                int extraSpaces = numOfSpaces % (numOfWords-1);
                for(int i = index; i<last ; i++){
                    sb.append(words[i]);
                    if(i!=(last-1)){
                        for(int j=0;j<= (spacesBetween+ (i - index <extraSpaces ?1:0));j++){
                            sb.append(" ");
                        }
                    }
                }
            }
            result.add(sb.toString());
            index =last;
        }
        return result;
    }
}