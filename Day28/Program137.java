// https://www.geeksforgeeks.org/problems/construct-tree-from-preorder-traversal/1

class Solution{
    Node constructTree(int n, int pre[], char preLN[]){
	    int index[] = {0};
	    return constructUtil(pre, preLN, index, n);
    }
    Node constructUtil(int pre[], char preLN[], int []index, int n){
        if(index[0]>=n) return null;
        
        Node node = new Node(pre[index[0]]);
        int i = index[0];
        index[0]+=1;
        
        if(preLN[i]=='N'){
            node.left = constructUtil(pre, preLN, index, n);
            node.right = constructUtil(pre, preLN, index, n);
        }
        return node;
    }
}