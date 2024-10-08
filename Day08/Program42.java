// https://leetcode.com/problems/largest-rectangle-in-histogram/description/


class Solution { // O(5*N) - Simulation
    public int largestRectangleArea(int[] heights) {
        int l = heights.length;
        int PSE[] = findPSE(heights); // O(2*n)
        int NSE[] = findNSE(heights); // O(2*n)
        
        int max = 0;
        for (int i = 0; i < l; i++) { // O(N)
            max = Math.max(max, heights[i] * (NSE[i] - PSE[i] - 1));
        }
        return max;
    }

    public int[] findPSE(int nums[]) {
        int l = nums.length;
        int PSE[] = new int[l];
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < l; i++) {
            while (!stk.isEmpty() && nums[stk.peek()] >= nums[i])
                stk.pop();

            if (stk.isEmpty())
                PSE[i] = -1;

            else
                PSE[i] = stk.peek();

            stk.push(i);
        }
        return PSE;
    }

    public int[] findNSE(int nums[]) {
        int l = nums.length;
        int NSE[] = new int[l];
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = l - 1; i >= 0; i--) {
            while (!stk.isEmpty() && nums[i] <= nums[stk.peek()])
                stk.pop();

            if (stk.isEmpty())
                NSE[i] = l;

            else
                NSE[i] = stk.peek();

            stk.push(i);
        }
        return NSE;
    }
}