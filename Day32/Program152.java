// https://leetcode.com/problems/furthest-building-you-can-reach/description/


class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            
            // If the next building is taller, calculate the difference
            if (diff > 0) {
                minHeap.add(diff);
            }
            
            // If the number of climbs (where ladders or bricks are needed) exceeds the number of ladders
            if (minHeap.size() > ladders) {
                // Use bricks for the smallest climb
                bricks -= minHeap.poll();
            }
            
            // If we don't have enough bricks, return the current building index
            if (bricks < 0) {
                return i;
            }
        }
        
        // If we can reach the last building
        return heights.length - 1;
    }
}