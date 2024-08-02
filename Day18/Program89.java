// https://leetcode.com/problems/reverse-linked-list/description/

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode temp =head;
        ListNode prev = null;
        while(temp!=null){
            ListNode curr = temp;
            temp = temp.next;
            curr.next =prev;
            prev=curr;
        }
        return prev;
    }
}