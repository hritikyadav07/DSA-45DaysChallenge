// https://leetcode.com/problems/binary-search-tree-iterator/


class BSTIterator {

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        // Initialize the stack with the leftmost path of the tree
        pushAllLeft(root);
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        int result = node.val;
        // If the node has a right child, push all its left children onto the stack
        if (node.right != null) {
            pushAllLeft(node.right);
        }
        return result;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // Helper function to push all the left children of a node onto the stack
    private void pushAllLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}