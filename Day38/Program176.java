// https://leetcode.com/problems/reorganize-string/description/


class Solution {
    public String reorganizeString(String s) {
        int freq[] = new int [26];
        for(char ch: s.toCharArray()){
            freq[ch-'a']++;
        }
        //Create a max-heap (priority queue) to store characters by frequency
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                //if any freq greater than half not possible
                if(freq[i]>(s.length()+1)/2){
                    return "";
                }
                maxHeap.offer(new int[]{i,freq[i]});
            }
        }

        StringBuilder result = new StringBuilder();
        while(maxHeap.size()>1){
            int[] first = maxHeap.poll();
            int[] second = maxHeap.poll();

            //append these at end 
            result.append((char)(first[0]+'a'));
            result.append((char)(second[0]+'a'));
            //decrease the frequency of both
            if(--first[1]>0){
                maxHeap.offer(first);
            }
            if(--second[1]>0){
                maxHeap.offer(second);
            }
        }
        if(!maxHeap.isEmpty()){
            result.append((char)(maxHeap.poll()[0]+'a'));
        }
        return result.toString();
    }
}