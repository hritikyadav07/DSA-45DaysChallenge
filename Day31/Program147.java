// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;

        Node leftNode = root;
        while(leftNode.left != null){
            Node head = leftNode;
            //adding all right nodes
            while(head != null){
                head.left.next = head.right;
                if(head.next != null){
                    head.right.next = head.next.left;
                }
                // assigning previous level next as any right nodes remaining
                head = head.next;
            }
            leftNode = leftNode.left;
        }
        return root;
    }
}