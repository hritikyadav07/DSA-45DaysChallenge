// https://www.geeksforgeeks.org/problems/subtraction-in-linked-list/1


class Solution {
    public Node subLinkedList(Node head1, Node head2) {
        // Step 1: Determine which number is larger
        head2 = removeLeadingZeros(head2);
        head1 = removeLeadingZeros(head1);
        if (compare(head1, head2) < 0) {
            Node temp = head1;
            head1 = head2;
            head2 = temp;
        }

        // Step 2: Reverse both lists
        head1 = reverseList(head1);
        head2 = reverseList(head2);

        // Step 3: Subtract head2 from head1
        Node result = subtract(head1, head2);

        // Step 4: Reverse the result list
        result = reverseList(result);

        // Step 5: Remove leading zeros
        result = removeLeadingZeros(result);

        return result;
    }

    private int compare(Node head1, Node head2) {
        int len1 = getLength(head1);
        int len2 = getLength(head2);
        if (len1 != len2) return len1 - len2;

        while (head1 != null && head2 != null) {
            if (head1.data != head2.data) return head1.data - head2.data;
            head1 = head1.next;
            head2 = head2.next;
        }
        return 0;
    }

    private int getLength(Node head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    private Node reverseList(Node head) {
        Node prev = null;
        while (head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    private Node subtract(Node head1, Node head2) {
        Node dummy = new Node(0);
        Node current = dummy;
        int borrow = 0;

        while (head1 != null || head2 != null) {
            int val1 = (head1 != null) ? head1.data : 0;
            int val2 = (head2 != null) ? head2.data : 0;

            int sub = val1 - val2 - borrow;
            if (sub < 0) {
                sub += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }

            current.next = new Node(sub);
            current = current.next;

            if (head1 != null) head1 = head1.next;
            if (head2 != null) head2 = head2.next;
        }

        return dummy.next;
    }

    private Node removeLeadingZeros(Node head) {
        while (head != null && head.data == 0) {
            head = head.next;
        }
        return (head == null) ? new Node(0) : head;
    }

}
