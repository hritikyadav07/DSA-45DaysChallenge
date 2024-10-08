// https://leetcode.com/problems/minimum-number-of-refueling-stops/description/

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (target <= startFuel)
            return 0;
        else if (stations.length == 0)
            return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int s = 0;
        int count = 0;
        int i = startFuel;
        int prev = -1;
        while(prev != i) {
            prev = i;
            while (s < stations.length && stations[s][0] <= i) {
                pq.add(stations[s][1]);
                s++;
            }

            if (i < target && !pq.isEmpty()) {
                i += pq.poll();
                count++;
            }
            if(i >= target) return count;

        }
        return -1;
    }
}
