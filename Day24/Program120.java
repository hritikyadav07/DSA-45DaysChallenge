// https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/



class Solution {
    TreeNode prev = null;
    int ans = Integer.MAX_VALUE;
    private void inorder(TreeNode root){
        if(root == null)
            return ;
        inorder(root.left);
        if(prev != null)
            ans = Math.min(ans, root.val - prev.val);
        prev = root;
        inorder(root.right);
        return ;
            
    }
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return ans;
    }
}