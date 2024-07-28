// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/description/
 class ListNode {
       int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
class Solution {
    public int getDecimalValue(ListNode head) {
        int result =0;
        ListNode temp = head;
        while(temp!=null){
            result*=2;
            result+=temp.val;
            temp = temp.next;
        }
        return result;
    }
}