// https://www.geeksforgeeks.org/problems/multiply-two-linked-lists/1


class Solution {
    private static final long MOD = 1000000007;

    // Function to convert a linked list to an integer
    private long listToNumber(Node head) {
        long number = 0;
        while (head != null) {
            number = (number * 10 + head.data) % MOD;
            head = head.next;
        }
        return number;
    }

    // Function to multiply two linked lists
    public long multiplyTwoLists(Node l1, Node l2) {
        long num1 = listToNumber(l1);
        long num2 = listToNumber(l2);
        return (num1 * num2) % MOD;
    }
}