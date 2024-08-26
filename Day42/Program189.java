// https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1

class Solution {
    // Function to find the minimum number of pages.
    public static int findPages( int n, int[] arr, int m) {
        // If number of students is more than number of books, it's impossible to allocate
        if (n < m) {
            return -1;
        }

        // Initialize the binary search boundaries
        int start = getMax(arr, n);  // Lower bound (max pages of a single book)
        int end = getSum(arr, n);    // Upper bound (sum of all pages)
        int result = Integer.MAX_VALUE;

        // Binary search
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Check if it is possible to allocate books with 'mid' as the max pages
            if (isFeasible(arr, n, m, mid)) {
                result = Math.min(result, mid); // Update the result if feasible
                end = mid - 1; // Try for a smaller value in the left half
            } else {
                start = mid + 1; // Try for a larger value in the right half
            }
        }

        return result;
    }

    // Helper function to check if a given number of pages is feasible
    private static boolean isFeasible(int[] arr, int n, int m, int mid) {
        int studentsRequired = 1;
        int currentPagesSum = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] > mid) {
                return false; // Single book has more pages than 'mid'
            }

            if (currentPagesSum + arr[i] > mid) {
                // Allocate to new student
                studentsRequired++;
                currentPagesSum = arr[i];

                if (studentsRequired > m) {
                    return false; // More students required than available
                }
            } else {
                // Add this book to the current student's allocation
                currentPagesSum += arr[i];
            }
        }

        return true;
    }

    // Helper function to get the maximum value in the array
    private static int getMax(int[] arr, int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // Helper function to get the sum of all elements in the array
    private static int getSum(int[] arr, int n) {
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += arr[i];
        }
        return total;
    }
};
