// https://leetcode.com/problems/linked-list-cycle/description/

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode turtle = head;
        ListNode hare = head;
        while(hare!=null && hare.next!=null){
            hare = hare.next.next;
            turtle = turtle.next;
            if(hare==turtle)return true;
        }
        return false;
    }
}