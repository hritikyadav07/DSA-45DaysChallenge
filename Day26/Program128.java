// https://leetcode.com/problems/validate-binary-search-tree/

class Solution {
    private long min = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null)return true;
        if(!isValidBST(root.left))return false;
        if(min>=root.val)return false;
        min = root.val;
        if(!isValidBST(root.right))return false;
        return true;
    }
}