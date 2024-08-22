// https://leetcode.com/problems/minimum-cost-to-hire-k-workers/

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        
        // Step 1: Create a 2D array to hold (quality, wage) pairs
        double[][] workers = new double[n][2];
        
        for (int i = 0; i < n; i++) {
            workers[i][0] = (double) quality[i];
            workers[i][1] = (double) wage[i] / quality[i]; // Calculate the ratio of wage/quality
        }
        
        // Step 2: Sort workers based on the ratio (wage/quality)
        Arrays.sort(workers, (a, b) -> Double.compare(a[1], b[1]));
        
        // Step 3: Use a max-heap to keep track of the top k qualities
        PriorityQueue<Double> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b, a));
        double totalQuality = 0.0;
        double minCost = Double.MAX_VALUE;
        
        // Step 4: Iterate through the sorted workers
        for (int i = 0; i < n; i++) {
            totalQuality += workers[i][0];
            maxHeap.add(workers[i][0]);
            
            // If the heap size exceeds k, remove the largest quality
            if (maxHeap.size() > k) {
                totalQuality -= maxHeap.poll();
            }
            
            // If the heap size equals k, calculate the potential minimum cost
            if (maxHeap.size() == k) {
                double cost = totalQuality * workers[i][1]; // totalQuality * current ratio
                minCost = Math.min(minCost, cost);
            }
        }
        
        return minCost;
    }
}
