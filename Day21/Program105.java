// https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1


class Solution {
    // Function to flatten a linked list
     Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node result;
        if (a.data < b.data) {
            result = a;
            result.bottom = merge(a.bottom, b);
        } else {
            result = b;
            result.bottom = merge(a, b.bottom);
        }
        result.next = null; // Ensure the next pointer is null for the merged list
        return result;
    }

    // Main function to flatten the linked list
    Node flatten(Node root) {
        if (root == null || root.next == null) return root;

        // Recur for the next list
        root.next = flatten(root.next);

        // Merge the current list with the flattened next list
        root = merge(root, root.next);

        return root;
    }
}