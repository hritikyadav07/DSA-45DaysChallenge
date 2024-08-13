// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/


import java.util.*;

class Solution {
    static class Tuple {
        TreeNode node;
        int row;
        int col;
        
        Tuple(TreeNode _node, int _row, int _col) {
            node = _node;
            row = _row;
            col = _col;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        // TreeMap to store nodes based on column index (keys), where each value is a map itself
        TreeMap<Integer, List<Tuple>> map = new TreeMap<>();
        
        // Queue for BFS traversal
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(root, 0, 0)); // Start with root at column 0 and row 0
        
        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int row = tuple.row;
            int col = tuple.col;
            
            // Add the node's value into the map at the correct column
            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(new Tuple(node, row, col));
            
            // Add left and right children to the queue with updated row and column values
            if (node.left != null) {
                queue.add(new Tuple(node.left, row + 1, col - 1));
            }
            if (node.right != null) {
                queue.add(new Tuple(node.right, row + 1, col + 1));
            }
        }
        
        // For each column in the map, sort the nodes first by row, then by value
        for (int col : map.keySet()) {
            List<Tuple> list = map.get(col);
            Collections.sort(list, (a, b) -> {
                if (a.row == b.row) {
                    return a.node.val - b.node.val;
                } else {
                    return a.row - b.row;
                }
            });
            
            // Extract the node values for the result
            List<Integer> colResult = new ArrayList<>();
            for (Tuple t : list) {
                colResult.add(t.node.val);
            }
            result.add(colResult);
        }
        
        return result;
    }
}
