// https://www.geeksforgeeks.org/problems/product-array-puzzle4525/1


class Solution {
    public static long[] productExceptSelf(int nums[], int n) {
        // Edge case: if there is only one element, return an array with one element {1}
        if (n == 1) {
            return new long[]{1};
        }

        // Initialize prefix and suffix arrays
        long[] prefix = new long[n];
        long[] suffix = new long[n];
        long[] result = new long[n];

        // Compute prefix products
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        // Compute suffix products
        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        // Compute the result by multiplying prefix and suffix products
        for (int i = 0; i < n; i++) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }
}