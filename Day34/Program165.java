// https://leetcode.com/problems/unique-binary-search-trees/

class Solution {
    public int numTrees(int n) {
        // Base cases
        if (n == 0 || n == 1) {
            return 1;
        }
        
        int count = 0;
        
        // Consider each number from 1 to n as root
        for (int i = 1; i <= n; i++) {
            // Recursively find the number of unique BSTs for the left and right subtrees
            int leftTrees = numTrees(i - 1);
            int rightTrees = numTrees(n - i);
            
            // Multiply the number of left and right subtrees and add to the count
            count += leftTrees * rightTrees;
        }
        
        return count;
    }
}
