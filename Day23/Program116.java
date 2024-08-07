// https://leetcode.com/problems/binary-tree-paths/

class Solution {
    List<String> paths = new ArrayList<>();
    public void hasPath(TreeNode root, List<String> path_val){
        if(root==null)return;
        path_val.add(""+root.val);
        if(root.left==null && root.right==null){
            String path = String.join("->", path_val);
            paths.add(path);
        } else{
            hasPath(root.left, path_val);
            hasPath(root.right, path_val);
        }
        path_val.remove(path_val.size()-1);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> path_val = new ArrayList<>();
        hasPath(root, path_val);
        return paths;
    }
}