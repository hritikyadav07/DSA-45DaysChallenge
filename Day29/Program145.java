// https://www.geeksforgeeks.org/problems/min-distance-between-two-given-nodes-of-a-binary-tree/1


class Solution {
    // Node class definition
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public int findDist(Node root, int a, int b) {
        // Find the LCA of nodes a and b
        Node lca = findLCA(root, a, b);

        // Find the distance from LCA to node a and from LCA to node b
        int distA = findLevel(lca, a, 0);
        int distB = findLevel(lca, b, 0);

        // Return the sum of both distances
        return distA + distB;
    }

    // Helper function to find the Lowest Common Ancestor (LCA)
    private Node findLCA(Node node, int a, int b) {
        if (node == null) return null;

        if (node.data == a || node.data == b) return node;

        Node left = findLCA(node.left, a, b);
        Node right = findLCA(node.right, a, b);

        if (left != null && right != null) return node;

        return (left != null) ? left : right;
    }

    // Helper function to find the level (distance) of a node from the given root
    private int findLevel(Node node, int data, int level) {
        if (node == null) return -1;

        if (node.data == data) return level;

        int left = findLevel(node.left, data, level + 1);
        if (left == -1) {
            return findLevel(node.right, data, level + 1);
        }
        return left;
    }
}

///////
