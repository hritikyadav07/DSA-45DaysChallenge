// https://leetcode.com/problems/find-the-most-competitive-subsequence/description/


class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        // Step 1: Create a deque to store the indices of elements in the competitive subsequence
        Deque<Integer> deque = new ArrayDeque<>();
        
        // Step 2: Calculate how many elements we can still drop from the array
        int n = nums.length;
        int elementsToDrop = n - k;
        
        // Step 3: Traverse the array
        for (int i = 0; i < n; i++) {
            // Step 4: While the deque is not empty and the current element is smaller
            // than the element at the back of the deque, and we still have elements to drop
            // Pop from the back of the deque
            while (!deque.isEmpty() && nums[i] < deque.peekLast() && elementsToDrop > 0) {
                deque.pollLast();
                elementsToDrop--;
            }
            
            // Step 5: Add the current element to the deque
            deque.offerLast(nums[i]);
        }
        
        // Step 6: Collect the first k elements from the deque to form the result
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = deque.pollFirst();
        }
        
        return result;
    }
}
