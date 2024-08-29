// https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/
class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        // Step 1: Create the adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            graph.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
            graph.computeIfAbsent(pair[1], k -> new ArrayList<>()).add(pair[0]);
        }
        
        // Step 2: Find the starting element (endpoint of the array)
        int start = -1;
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            if (entry.getValue().size() == 1) {
                start = entry.getKey();
                break;
            }
        }
        
        // Step 3: Reconstruct the array
        int[] result = new int[adjacentPairs.length + 1];
        result[0] = start;
        
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        int prev = start;
        
        for (int i = 1; i < result.length; i++) {
            List<Integer> neighbors = graph.get(prev);
            // Find the next element which is not visited
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    result[i] = neighbor;
                    visited.add(neighbor);
                    prev = neighbor;
                    break;
                }
            }
        }
        
        return result;
    }
}
