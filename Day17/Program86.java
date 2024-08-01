// https://leetcode.com/problems/intersection-of-two-linked-lists/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Program86 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1=headA, temp2;
        while(temp1!=null)
        {
            temp2=headB;
            while(temp2!=null)
            {
                if(temp1==temp2)
                {
                    if(temp1.next==temp2.next)return temp1;
                }
                temp2=temp2.next;
            }
            temp1=temp1.next;
        }
        return null;
    }
}