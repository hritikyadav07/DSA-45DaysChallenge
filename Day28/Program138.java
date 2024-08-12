// https://www.geeksforgeeks.org/problems/largest-bst/1

class Solution{
    
    class Info{
        int size;  // Size of the subtree
        int max;   // Maximum value in the subtree
        int min;   // Minimum value in the subtree
        boolean isBST;  // If the subtree is a BST

    Info(int size, int max, int min, boolean isBST) {
        this.size = size;
        this.max = max;
        this.min = min;
        this.isBST = isBST;
    }
    }
    // Return the size of the largest sub-tree which is also a BST
    int largestBst(Node root)
    {
        Info result = largestBSTUtil(root);
        return result.size;
    }
     Info largestBSTUtil(Node node){
        if (node == null) {
            return new Info(0, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        }
        if (node.left == null && node.right == null) {
            return new Info(1, node.data, node.data, true);
        }
        Info leftInfo = largestBSTUtil(node.left);
        Info rightInfo = largestBSTUtil(node.right);
        
        Info current = new Info(0, 0, 0, false);
        current.size = leftInfo.size + rightInfo.size + 1;
        // Check if the current node is a BST
        if (leftInfo.isBST && rightInfo.isBST && leftInfo.max < node.data && node.data < rightInfo.min) {
            current.min = Math.min(leftInfo.min, node.data);
            current.max = Math.max(rightInfo.max, node.data);
            current.isBST = true;
            return current;
        }

        // If the current subtree is not a BST, take the maximum size of the BSTs in its left or right subtree
        current.size = Math.max(leftInfo.size, rightInfo.size);
        current.isBST = false;
        return current;

    }
    
}