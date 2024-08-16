// https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1



class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        
        int sum = 0;
        int maxLength = 0;
        
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            
            // If sum is zero, the subarray from 0 to i has sum 0
            if (sum == 0) {
                maxLength = i + 1;
            }
            
            // If this sum has been seen before, there is a subarray with sum 0
            if (sumMap.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - sumMap.get(sum));
            } else {
                // Store the sum with the corresponding index
                sumMap.put(sum, i);
            }
        }
        
        return maxLength;
    }
}