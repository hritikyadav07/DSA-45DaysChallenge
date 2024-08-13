// https://www.geeksforgeeks.org/problems/min-distance-between-two-given-nodes-of-a-binary-tree/1


class Solution {
    // TreeNode class definition
    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    public int findDist(TreeNode root, int a, int b) {
        // Find the LCA of nodes a and b
        TreeNode lca = findLCA(root, a, b);

        // Find the distance from LCA to node a and from LCA to node b
        int distA = findLevel(lca, a, 0);
        int distB = findLevel(lca, b, 0);

        // Return the sum of both distances
        return distA + distB;
    }

    // Helper function to find the Lowest Common Ancestor (LCA)
    private TreeNode findLCA(TreeNode node, int a, int b) {
        if (node == null) return null;

        if (node.val == a || node.val == b) return node;

        TreeNode left = findLCA(node.left, a, b);
        TreeNode right = findLCA(node.right, a, b);

        if (left != null && right != null) return node;

        return (left != null) ? left : right;
    }

    // Helper function to find the level (distance) of a node from the given root
    private int findLevel(TreeNode node, int val, int level) {
        if (node == null) return -1;

        if (node.val == val) return level;

        int left = findLevel(node.left, val, level + 1);
        if (left == -1) {
            return findLevel(node.right, val, level + 1);
        }
        return left;
    }
}
