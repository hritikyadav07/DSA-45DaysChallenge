// https://www.geeksforgeeks.org/problems/delete-nodes-having-greater-value-on-right/1


class Solution
{
    Node compute(Node head)
    {
        // Reverse the linked list
        head = reverseList(head);

        // Traverse the reversed list and remove nodes
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        Node curr = head;
        int maxSoFar = Integer.MIN_VALUE;

        while (curr != null) {
            if (curr.data >= maxSoFar) {
                maxSoFar = curr.data;
                prev = curr;
            } else {
                prev.next = curr.next;
            }
            curr = curr.next;
        }

        // Reverse the list again to restore original order
        return reverseList(dummy.next);
    }
    private Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    
}