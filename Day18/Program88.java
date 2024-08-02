// https://leetcode.com/problems/palindrome-linked-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow =slow.next;
            fast = fast.next.next;
        }
        slow = reverseList(slow);
        System.out.println(slow.val);
        ListNode temp =head;
        while(slow!=null){
            if(temp.val != slow.val){
                return false;
            }
            temp=temp.next;
            slow = slow.next;
        }
        return true;
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