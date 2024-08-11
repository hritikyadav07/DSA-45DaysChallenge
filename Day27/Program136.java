// https://www.geeksforgeeks.org/problems/the-celebrity-problem/1


class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        // code here
        int n = mat.length;
        Stack<Integer> stack = new Stack<>();

        // Step 1: Push all the people to the stack
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        // Step 2: Determine the potential celebrity
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();

            if (mat[a][b] == 1) {
                // a knows b, so a cannot be a celebrity, but b might be
                stack.push(b);
            } else {
                // a does not know b, so b cannot be a celebrity, but a might be
                stack.push(a);
            }
        }

        // The last person in the stack is the potential celebrity
        int candidate = stack.pop();

        // Step 3: Verify the candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate && (mat[candidate][i] == 1 || mat[i][candidate] == 0)) {
                return -1;
            }
        }

        return candidate;
    }
} 