// https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/description/


class Solution {
    public int minDeletions(String s) {
        int freq[] = new int[26];
        for(char ch: s.toCharArray()){
            freq[ch-'a']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int f:freq){
            if(f>0){
                pq.add(f);
            }
        }
        int deletions =0;
        while(pq.size()>1){
            int top = pq.poll();
            if(top==pq.peek()){
                if(top-1>0){
                    pq.add(top-1);
                }
                deletions++;
            }
            
        }
        return deletions;
    }
}