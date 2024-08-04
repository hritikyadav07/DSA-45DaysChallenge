// https://geeksforgeeks.org/rearrange-a-given-linked-list-in-place/


class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow =slow.next;
            fast = fast.next.next;
        }
        slow = reverseList(slow);
        ListNode result = head;
        while(slow!=null){
            ListNode temp = slow.next;
            slow.next = result.next;
            result.next = slow;
            result = slow.next;
            slow = temp;
        }
        result.next =null;
    }
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
        return head;
        ListNode n1=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return n1;        
    }
}