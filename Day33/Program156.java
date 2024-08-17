// https://leetcode.com/problems/binary-tree-cameras/

//Definition for a binary tree node.
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int minCameraCover(TreeNode root) {
        int[] camera = {0};
        if(fun(root,camera) == 0) camera[0]++;
        return camera[0];
    }
    public int fun(TreeNode node, int[] camera){
        if(node == null){//null not monitored or not doesn't matter
            return 1;
        }
        int l = fun(node.left, camera);//what is the status of immediate left node camera
        int r = fun(node.right, camera);//what is the status of immediate right node camera
        if(l==0 || r==0){//either left side or right is not being monitored so add camera 
        camera[0]++;
        return 2;
        } else if(l==2 || r==2){// left or right is being monitored so me also being monitored
        return 1;
        } else{ //l==1 ||r==1 left or right monitored with camera but range not till me so i am not being monitored
        return 0;
        }
    }
}
//CameraMan's Mind Camera status
// 0 - this node is not being monitored 
// 1 - this node is being monitored but camera is not here
// 2 - camera added here