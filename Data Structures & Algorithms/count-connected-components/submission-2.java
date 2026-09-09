class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        return uf.getComponents();
    }
}


class UnionFind {
    private int[] parents;
    private int[] size;
    private int components;

    public UnionFind(int n) {
        parents = new int[n];
        size = new int[n];
        components = n;
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        if (parents[x] != x) {
            parents[x] = find(parents[x]);
        }

        return parents[x];
    }

    public void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU == rootV) return;
        if (size[rootU] >= size[rootV]) {
            parents[rootV] = rootU;
            size[rootU] += size[rootV];
        } else {
            parents[rootU] = rootV;
            size[rootV] += size[rootU];
        }

        components--;
    }

    public int getComponents() {
        return this.components;
    }

}