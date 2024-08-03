// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode temp = head ; 
        int i = 0;
        while(temp!=null){
            map.put(i+1, temp);
            i++;
            temp = temp.next;
        }
        if(i==n){
            return head.next;
        } else{
            ListNode tp = map.get(i-n);
            tp.next = tp.next.next;
        }
        return head;
    }
}