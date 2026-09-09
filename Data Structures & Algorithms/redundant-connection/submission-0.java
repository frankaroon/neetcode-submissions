class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] ans = new int[2];

        UnionFind uf = new UnionFind(edges.length + 1);
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) {
                ans = edge;
            }
        }

        return ans;
    }
}

class UnionFind {
    int[] parent;
    int[] size;

    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // recursively find root/parent of x while executing path compression
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    public boolean union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU == rootV) {
            return false;
        }

        if (size[rootU] <= size[rootV]) {
            parent[rootU] = rootV;
            size[rootV] += size[rootU];
        } else {
            parent[rootV] = rootU;
            size[rootU] += size[rootV];
        }

        return true;
    }
}