// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/

class Solution {
    public int strStr(String haystack, String needle) {
        int n= haystack.length();
        int k = needle.length();
        for(int i =0;i<n-k+1;i++){
            if(haystack.substring(i,i+k).compareTo(needle)==0){
                return i;
            }
        }
        return -1;
    }
}