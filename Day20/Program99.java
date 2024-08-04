// https://leetcode.com/problems/sort-list/description/


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
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)//when there is a single node or empty list
        return head;
        ListNode prev=null; //pointer to break linkedlist
        ListNode turtle=head;  //slow moving node with speed 1
        ListNode hare=head;     //fast moving node with speed 2
        while(hare!=null && hare.next!=null){   //hare-turtle algo
            prev=turtle;
            turtle=turtle.next;
            hare=hare.next.next;
        }
        prev.next=null; //breaking list at middle node
        ListNode part1 = sortList(head);    //pass 1st-half
        ListNode part2 = sortList(turtle);    //pass 2nd-half
        return mergeList(part1,part2);      //merge  both

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