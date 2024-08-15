// https://www.geeksforgeeks.org/problems/count-bst-nodes-that-lie-in-a-given-range/1


class Solution {
    // Function to count the number of nodes in the BST that lie in the given range
    int getCount(TreeNode root, int l, int h) {
        // Base Case
        if (root == null) {
            return 0;
        }

        // If the current node is in the range [l, h]
        if (root.data >= l && root.data <= h) {
            // Count this node and recurse for left and right subtrees
            return 1 + getCount(root.left, l, h) + getCount(root.right, l, h);
        }
        // If the current node's value is less than l, then recurse on the right subtree
        else if (root.data < l) {
            return getCount(root.right, l, h);
        }
        // If the current node's value is greater than h, then recurse on the left subtree
        else {
            return getCount(root.left, l, h);
        }
    }
}

///////
