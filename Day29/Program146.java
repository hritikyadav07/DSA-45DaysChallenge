// https://www.geeksforgeeks.org/problems/preorder-to-postorder4423/1


class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

class Solution {
    private int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return constructBST(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode constructBST(int[] preorder, int minValue, int maxValue) {
        if (index == preorder.length) {
            return null;
        }

        int value = preorder[index];

        // The current value should be within the range defined by minValue and maxValue.
        if (value < minValue || value > maxValue) {
            return null;
        }

        // Create the root node for this subtree
        TreeNode root = new TreeNode(value);
        index++;

        // All elements less than the current value will form the left subtree
        root.left = constructBST(preorder, minValue, value - 1);

        // All elements greater than the current value will form the right subtree
        root.right = constructBST(preorder, value + 1, maxValue);

        return root;
    }
}
