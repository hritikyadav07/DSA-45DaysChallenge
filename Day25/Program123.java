// https://www.geeksforgeeks.org/problems/predecessor-and-successor/1


class Solution {
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        pre[0] = null;
        suc[0] = null;

        while (root != null) {
            if (root.data == key) {
                // Find the predecessor (rightmost node in left subtree)
                if (root.left != null) {
                    Node temp = root.left;
                    while (temp.right != null) {
                        temp = temp.right;
                    }
                    pre[0] = temp;
                }
                // Find the successor (leftmost node in right subtree)
                if (root.right != null) {
                    Node temp = root.right;
                    while (temp.left != null) {
                        temp = temp.left;
                    }
                    suc[0] = temp;
                }
                return;
            } else if (root.data > key) {
                // If root's key is greater, go to the left subtree
                // and update successor
                suc[0] = root;
                root = root.left;
            } else {
                // If root's key is smaller, go to the right subtree
                // and update predecessor
                pre[0] = root;
                root = root.right;
            }
        }
    }
}