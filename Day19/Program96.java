// https://leetcode.com/problems/partition-list/description/

class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head ==null || head.next==null)return head;
        ListNode greater = new ListNode(-1);
        ListNode smaller = new ListNode(-1);
        ListNode ans = smaller;
        ListNode ans2 = greater;
        while(head!=null){
            ListNode add =  head;
            head = head.next;
            add.next=null;
            if(add.val<x){
                smaller.next = add;
                smaller =add;
            } else {
                greater.next = add;
                greater = add;
            }
        }
        smaller.next =ans2.next;
        return ans.next;
    }
}