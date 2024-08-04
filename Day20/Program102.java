// https://leetcode.com/problems/merge-k-sorted-lists/


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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        for(int i =0;i<lists.length;i++){
            head = mergeList(head,lists[i]);
        }
        return head;
    }
    public ListNode mergeList(ListNode left,ListNode right){
        ListNode add=new ListNode(0);
        ListNode head=add;
        while(left!=null && right!=null){
            if(left.val<right.val){
                add.next=left;
                left=left.next;
            }
            else{
                add.next=right;
                right=right.next;
            }
        add=add.next;
        }
        if(left!=null)
            add.next=left;
        if(right!=null)
            add.next=right;
        return head.next;
    }
}