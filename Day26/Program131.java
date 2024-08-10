// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

class Solution { 
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        boolean leftToRight =true; // this change for zigzag
        if(root == null)return ans;
        que.add(root);
        while(!que.isEmpty()){
            List<Integer> list = new LinkedList<>();
            int size = que.size();

            for(int i =0;i<size;i++){
                TreeNode node = que.poll();
                if(leftToRight){
                    list.add(node.val);
                } else {
                    list.add(0, node.val);
                }
                if(node.left!=null){
                    que.add(node.left);
                }
                if(node.right!=null){
                    que.add(node.right);
                }
            }
            ans.add(list);
            leftToRight = !leftToRight;
        }
        return ans;
    }
}