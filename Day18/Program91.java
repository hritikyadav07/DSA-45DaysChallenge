// https://leetcode.com/problems/copy-list-with-random-pointer/description/


/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node ptr =head;
        Node copy=new Node(-1);
        Node ans=copy;
        HashMap<Node,Node> hash=new HashMap<>();
        while(ptr!=null){
            Node n1=new Node(ptr.val);
            copy.next=n1;
            copy=copy.next;
            hash.put(ptr,copy);
            ptr=ptr.next;
        }
        ptr=head;
        copy=ans.next;
        while(ptr!=null){
            Node x=ptr.random;
            Node y=hash.get(x);
            if(x==null) copy.random=null;
            else  copy.random=y;
            ptr=ptr.next;
            copy=copy.next;
        }
        return ans.next;
    }
}