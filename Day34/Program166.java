// https://leetcode.com/problems/unique-binary-search-trees-ii/



class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<>();
        return generateTrees(1,n);
    }
    public List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> allTrees = new ArrayList<>();
        if(start>end){
            allTrees.add(null);
            return allTrees;
        }
        for(int i = start;i<=end;i++){
            List<TreeNode> leftTrees = generateTrees(start, i-1);
            List<TreeNode> rightTrees = generateTrees(i+1, end);
            // generate all left Substrees ans right subtrees with i as root
            for(TreeNode left: leftTrees){
                for(TreeNode right:rightTrees){
                    TreeNode current = new TreeNode(i);
                    current.left =left;
                    current.right =right;
                    allTrees.add(current);
                }
            }
        }
        return allTrees;
    }
}