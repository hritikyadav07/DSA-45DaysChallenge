// https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/


class Solution {
    private int count = 0;
    private int result = Integer.MIN_VALUE;

    public int kthSmallest(TreeNode root, int k) {
        // Perform in-order traversal
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode node, int k) {
        // Base case: If the node is null, return
        if (node == null) {
            return;
        }

        // Traverse the left subtree
        inorder(node.left, k);

        // Increment the counter as we visit a node
        count++;

        // If the count equals k, we've found our k-th smallest element
        if (count == k) {
            result = node.val;
            return;
        }

        // Traverse the right subtree
        inorder(node.right, k);
    }
}




/////