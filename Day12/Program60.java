// https://www.geeksforgeeks.org/check-reversing-sub-array-make-array-sorted/

import java.util.Arrays;

class Solution {
    static boolean checkReverse(int arr[], int n) {
        int[] temp = Arrays.copyOf(arr, n);
        Arrays.sort(temp);

        // Finding the first mismatch
        int front; 
        for (front = 0; front < n; front++) { 
            if (temp[front] != arr[front]) { 
                break; 
            } 
        } 

        // Finding the last mismatch  
        int back; 
        for (back = n - 1; back >= 0; back--) { 
            if (temp[back] != arr[back]) { 
                break; 
            } 
        } 

        // If there are no mismatches, the array is already sorted
        if (front >= back) { 
            return true; 
        } 

        // Check if the sub-array from front to back is in descending order
        do { 
            front++; 
            if (arr[front - 1] < arr[front]) { 
                return false; 
            } 
        } while (front != back); 

        return true; 
    }

    public static void main(String[] args) { 
        int arr[] = {1, 2, 5, 4, 3}; 
        int n = arr.length; 

        if (checkReverse(arr, n)) { 
            System.out.print("Yes"); 
        } else { 
            System.out.print("No"); 
        } 
    } 
}
