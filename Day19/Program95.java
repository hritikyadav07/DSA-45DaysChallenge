// https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/description/

class Solution {
    public Node flatten(Node head) {
        if (head == null) return head;

        // Call the recursive helper function
        flattenRecursive(head);
        
        return head;
    }

    private Node flattenRecursive(Node node) {
        Node current = node;
        Node last = node;

        while (current != null) {
            Node next = current.next;

            // If there's a child, process it
            if (current.child != null) {
                Node childLast = flattenRecursive(current.child);

                // Insert the child list in between current and next
                current.next = current.child;
                current.child.prev = current;

                // If next is not null, connect it to the last node of the flattened child list
                if (next != null) {
                    childLast.next = next;
                    next.prev = childLast;
                }

                // Set child to null as it's been flattened
                current.child = null;

                // Update last to childLast
                last = childLast;
            } else {
                last = current;
            }

            // Move to the next node
            current = next;
        }

        return last;
    }
}
