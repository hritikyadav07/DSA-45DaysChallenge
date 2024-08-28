// https://leetcode.com/problems/sliding-window-maximum/description/


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];
        int ri = 0;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for(int i = 0 ; i<n ; i++){
            if(!dq.isEmpty() && dq.peekFirst()== i-k)
                dq.pollFirst();
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.offer(i);
            if(i>=k-1)
                result[ri++] = nums[dq.peekFirst()];
        }
        return result;
    }
}