// https://leetcode.com/problems/max-value-of-equation/


import java.util.*;

class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        Deque<int[]> deque = new LinkedList<>();
        int max = Integer.MIN_VALUE;

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            // Remove points from the deque that are out of the k distance
            while (!deque.isEmpty() && x - deque.peekFirst()[0] > k) {
                deque.pollFirst();
            }

            // Calculate the max value of the equation
            if (!deque.isEmpty()) {
                max = Math.max(max, x + y + deque.peekFirst()[1] - deque.peekFirst()[0]);
            }

            // Maintain the deque to keep the maximum y - x values
            while (!deque.isEmpty() && y - x >= deque.peekLast()[1] - deque.peekLast()[0]) {
                deque.pollLast();
            }

            deque.offerLast(new int[]{x, y});
        }

        return max;
    }
}
