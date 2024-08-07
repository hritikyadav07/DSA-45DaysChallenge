// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums, 0, nums.length-1);
    }
    public TreeNode createBST(int[] nums, int low, int high){
        if(low>high){
            return null;
        }
        int mid = (low+high)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createBST(nums, low, mid-1);
        root.right = createBST(nums, mid+1, high);
        return root;
    }
}