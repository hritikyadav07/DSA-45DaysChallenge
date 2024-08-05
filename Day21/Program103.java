// https://leetcode.com/problems/reverse-nodes-in-k-group/description/


/**
 * Definition for singly-linked list.
 *  class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
         if (head == null || k == 1) return head;
        ListNode temp=head;
        int count=0;
        ListNode ans = head;
        ListNode newhead = null;
        while(temp!=null){
            count=0;
            ListNode cut = temp;
            ListNode prev = null;
            while(count<k && temp!=null){
                prev =temp;
                temp = temp.next;
                count+=1;
            }
            if(count==k){
                prev.next = null;

                cut = reverseList(cut);
                if(ans==head){
                    ans = cut;
                }
                if(newhead!=null){
                    newhead.next=cut;
                }
                while(cut.next!=null){
                    cut=cut.next;
                }
                cut.next =temp;
                newhead = cut;
            } else break;
        }
        return ans;
    }
    public ListNode reverseList(ListNode head) {    // reverse the list
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