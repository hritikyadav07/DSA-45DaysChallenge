// https://leetcode.com/problems/sum-of-subarray-minimums/

class Solution {

    int[] getFSI(int arr[]) {
        int n = arr.length;
        int ans[] = new int[n];
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {

            while (!stk.isEmpty() && arr[stk.peek()] > arr[i])
                stk.pop();

            if (stk.isEmpty())
                ans[i] = n;
            else
                ans[i] = stk.peek();

            stk.push(i);
        }
        // System.out.println(Arrays.toString(ans));
        return ans;
    }

    int[] getPSI(int arr[]) {
        int n = arr.length;
        int ans[] = new int[n];
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {

            while (!stk.isEmpty() && arr[stk.peek()] >= arr[i])
                stk.pop();

            if (stk.isEmpty())
                ans[i] = -1;
            else
                ans[i] = stk.peek();

            stk.push(i);
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long MOD = (long) Math.pow(10, 9) + 7;
        int PSI[] = getPSI(arr);
        int FSI[] = getFSI(arr);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long left = i - PSI[i];
            long right = FSI[i] - i;
            ans += (left * right * arr[i]) % MOD;
        }
        return (int) (ans % MOD);
    }
}