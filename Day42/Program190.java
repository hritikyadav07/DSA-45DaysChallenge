// https://leetcode.com/problems/number-of-operations-to-make-network-connected/description/


class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            // Not enough edges to connect all nodes
            return -1;
        }

        UnionFind uf = new UnionFind(n);

        // Process each connection and perform union operations
        for (int[] conn : connections) {
            uf.union(conn[0], conn[1]);
        }

        // Count the number of distinct components
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (uf.find(i) == i) {
                components++;
            }
        }

        // The number of operations required to connect all components
        return components - 1;
    }

    private class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }
}
