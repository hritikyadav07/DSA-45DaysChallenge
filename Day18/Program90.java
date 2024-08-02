// https://leetcode.com/problems/add-two-numbers/



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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode ans  = result;
        int carry = 0;
        while(l1!=null && l2!=null){
            int num = l1.val +l2.val+carry;
            carry = num/10;
            num%=10;
            ListNode add = new ListNode(num);
            result.next = add;
            result =add;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            int num = l1.val +carry;
            carry = num/10;
            num%=10;
            ListNode add = new ListNode(num);
            result.next =add;
            result =add;
            l1 = l1.next;
        }
        while(l2!=null){
            int num =l2.val+carry;
            carry = num/10;
            num%=10;
            ListNode add = new ListNode(num);
            result.next =add;
            result =add;
            l2 = l2.next;
        }
        if(carry>0){
            ListNode add = new ListNode(carry);
            result.next =add;
            result =add;
        }
        return ans.next;

    }
}