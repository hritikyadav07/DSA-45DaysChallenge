// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/


class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> que = new PriorityQueue<>((a,b)->b-a);
        for(int[]row : matrix){
            for(int val: row){
                que.offer(val);
                if(que.size()>k){
                    que.poll();
                }
            }
        }
        return que.poll();
    }
}