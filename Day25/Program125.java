// https://www.geeksforgeeks.org/problems/check-whether-bst-contains-dead-end/1


class Solution
{
    public static boolean isDead(Node node,int min,int max){
        if(node==null) return false;

           if(min==max){
            return true;}
         
        
        return isDead(node.left,min,node.data-1) ||
        isDead(node.right,node.data+1,max);
 
    }
    public static boolean isDeadEnd(Node root)
    {
        //Add your code here.
         return isDead(root,1,Integer.MAX_VALUE);
        
    }
}