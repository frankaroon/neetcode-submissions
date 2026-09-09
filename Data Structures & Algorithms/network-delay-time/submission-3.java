class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // build adjacency list: node -> [neighbor, time]
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] time : times) {
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> minHeap =
            new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.add(new int[]{0, k}); // (distance, node)

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int distance = curr[0];
            int node = curr[1];

            if (distance > dist[node]) continue;

            for (int[] edge : graph.get(node)) {
                int neighbor = edge[0];
                int time = edge[1];

                if (dist[neighbor] > distance + time) {
                    dist[neighbor] = distance + time;
                    minHeap.add(new int[]{dist[neighbor], neighbor});
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}
