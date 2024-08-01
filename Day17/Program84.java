// https://leetcode.com/problems/merge-two-sorted-lists/description/


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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merged =new ListNode(-1);
        ListNode answer=merged;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                merged.next=list1;
                list1=list1.next;
                merged=merged.next;
            } else {
                merged.next=list2;
                list2=list2.next;
                merged=merged.next;
            }
        }
        while(list1!=null){
                merged.next=list1;
                list1=list1.next;
                merged=merged.next;
        }
        while(list2!=null){
                merged.next=list2;
                list2=list2.next;
                merged=merged.next;
        }
        return answer.next;
    }
}