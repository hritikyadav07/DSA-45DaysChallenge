// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/

class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        // Flatten the left subtree
        flatten(root.left);
        // Flatten the right subtree
        flatten(root.right);

        // Store the right subtree in a temporary variable
        TreeNode tempRight = root.right;

        // Move the left subtree to the right
        root.right = root.left;
        root.left = null;

        // Traverse to the end of the newly attached right subtree
        while (root.right != null) {
            root = root.right;
        }

        // Attach the original right subtree
        root.right = tempRight;
    }
}
