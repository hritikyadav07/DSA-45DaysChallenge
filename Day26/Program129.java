// https://leetcode.com/problems/binary-tree-right-side-view/description/

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if(root ==null){
            return ans;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int level_size = que.size();
            for(int i =0;i<level_size;i++){
                TreeNode node = que.poll();
                if(node.left!=null){
                    que.add(node.left);
                }
                if(node.right!=null){
                    que.add(node.right);
                }
                if(i==level_size-1){
                    ans.add(node.val);
                }
            }
        }
        return ans;
    }
}