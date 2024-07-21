// https://www.geeksforgeeks.org/permute-two-arrays-sum-every-pair-greater-equal-k/

class one{
    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // Swap the elements at left and right indices
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            // Move the pointers towards the middle
            left++;
            right--;
        }
    }
    static boolean isPossible(int a[], int b[], int n, int k) {


        Arrays.sort(a);
        reverseArray(a);

        Arrays.sort(b);

        for (int i = 0; i < n; i++)
        if (a[i] + b[i] < k)
            return false;

        return true;
    }
}