//* */ https://leetcode.com/problems/binary-tree-maximum-path-sum/


class Solution {
    public int maxPathSum(TreeNode root) {
        int ans[] = {Integer.MIN_VALUE};
        fun(root,ans);
        return ans[0];
    }
    public int fun(TreeNode node, int[] ans){
        if(node == null){
            return 0;
        }
        int l = fun(node.left, ans); // gets path of max sum in left
        int r = fun(node.right, ans); // gets path pf max sum in right
        
        int val = node.val; //case-1
        int val2 = Math.max(l,r)+node.val;
        int val3 = l+r+node.val;
        //uodate the answer
        ans[0] = Math.max(ans[0], val);
        ans[0] = Math.max(ans[0], val2);
        ans[0] = Math.max(ans[0],val3);
        return Math.max(val, val2);
    }
}

// there are three conditions
// 1. either the element is leaf node // or only that node is the answer
// 2. either our ans is in (left max path + current node)
// 3. or our ans is left max + right max path + current node