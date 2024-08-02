// https://leetcode.com/problems/add-two-numbers-ii/description/

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
        ListNode list1 = reverseList(l1);
        ListNode list2 = reverseList(l2);
        ListNode result = null;
        int carry = 0;
        while(list1!=null && list2!=null){
            int num = list1.val +list2.val+carry;
            carry = num/10;
            num%=10;
            ListNode add = new ListNode(num);
            add.next = result;
            result =add;
            list1 = list1.next;
            list2 = list2.next;
        }
        while(list1!=null){
            int num = list1.val +carry;
            carry = num/10;
            num%=10;
            ListNode add = new ListNode(num);
            add.next = result;
            result =add;
            list1 = list1.next;
        }
        while(list2!=null){
            int num =list2.val+carry;
            carry = num/10;
            num%=10;
            ListNode add = new ListNode(num);
            add.next = result;
            result =add;
            list2 = list2.next;
        }
        if(carry>0){
            ListNode add = new ListNode(carry);
            add.next = result;
            result =add;
        }
        return result;

    }
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