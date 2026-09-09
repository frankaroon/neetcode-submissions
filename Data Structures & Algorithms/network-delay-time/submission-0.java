class Solution {
    List<List<int[]>> graph;

    public int networkDelayTime(int[][] times, int n, int k) {
        // build out the graph adjacency list
        // source node -> neighbors: [[neighbor node, time], ...];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] time : times) {
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }
        
        int[] dist = new int[n+1];
        for (int i = 1; i <= n; i++) { 
            dist[i] = Integer.MAX_VALUE; 
        }

        dfs(k, 0, dist);

        int minDistance = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            minDistance = Math.max(minDistance, dist[i]);
        }

        return minDistance;
    }

    private void dfs(int node, int time, int[] dist) {
        // base if current path time is higher than what is stored
        if (time >= dist[node]) {
            return;
        }

       dist[node] = time;

       for (int[] neighbor : graph.get(node)) {
            dfs(neighbor[0], neighbor[1] + time, dist);
       }
    }
}

/*
    solved using DFS calculate the shortest path considering the weights
    1) build out the graph/adj list
    2) dfs from the start node
    3) keep track of the min(path) where all nodes have been visited
    4) at the end check if all nodes are visited if not then return -1
*/
