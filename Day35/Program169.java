// https://leetcode.com/problems/k-closest-points-to-origin/description/

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                int distanceA = a[0] * a[0] + a[1] * a[1];
                int distanceB = b[0] * b[0] + b[1] * b[1];
                return Integer.compare(distanceA, distanceB); // Ascending order
            }
        );
        for(int[]point: points){
            pq.offer(point);
        }
        for(int i=0;i<k;i++){
            int[] point = pq.poll();
            result[i][0] = point[0];
            result[i][1] = point[1];
        }
        return result;
    }
}