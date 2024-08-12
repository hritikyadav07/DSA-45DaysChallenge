// https://www.geeksforgeeks.org/problems/median-of-bst/1

class Tree
{
    int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    public float findMedian(Node root)
    {
        if (root == null) {
            return 0;
        }

        // Count the total number of nodes in the BST
        int count = countNodes(root);

        // If count is odd, return the middle element
        if (count % 2 != 0) {
            return kthNode(root, (count / 2) + 1, new int[]{0});
        } else {
            // If count is even, return the average of the two middle elements
            float leftMiddle = kthNode(root, count / 2, new int[]{0});
            float rightMiddle = kthNode(root, (count / 2) + 1, new int[]{0});
            return (leftMiddle + rightMiddle) / 2.0f;
        }
    }
     // Helper function to find the k-th node during in-order traversal
    int kthNode(Node root, int k, int[] count) {
        if (root == null) {
            return -1;
        }

        // Traverse the left subtree
        int left = kthNode(root.left, k, count);
        if (left != -1) {
            return left;  // Found in the left subtree
        }

        // Increment count and check if current node is the k-th node
        count[0]++;
        if (count[0] == k) {
            return root.data;
        }

        // Traverse the right subtree
        return kthNode(root.right, k, count);
    }
}