class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        // Prim algorithm 
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        int currNode = 0, edges = 0, res = 0;
        boolean[] visited = new boolean[n];

        while (edges < n - 1) {
            visited[currNode] = true;
            int nextNode = -1;
            for (int i = 0; i < n; i++) {
                if (visited[i]) continue;
                int nextDistance = Math.abs(points[currNode][0] - points[i][0]) +
                                     Math.abs(points[currNode][1] - points[i][1]);
                dist[i] = Math.min(dist[i], nextDistance);
                if (nextNode == -1 || dist[i] < dist[nextNode]) {
                    nextNode = i;
                }
            }
            res += dist[nextNode];
            currNode = nextNode;
            edges++;
        } 

        return res;
    }
}

// minimum spanning tree (prims algorithm) using this is better since graph is dense rather than a sparse kruskals
// we keep spanning the tree until we reach n - 1 edges
// - no need to represent this as a graph we can find the shortest distance as we traverse
// - cost = |xi - xj| + |yi - yj|