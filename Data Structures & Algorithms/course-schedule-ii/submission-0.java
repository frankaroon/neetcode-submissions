class Solution {
    private List<Integer> result = new ArrayList<>();
    private int[] indegrees;
    private List<List<Integer>> graph;

    public int[] findOrder(int numCourses, int[][] prereqs) {
        graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        indegrees = new int[numCourses];
        for (int[] prereq : prereqs) {
            graph.get(prereq[1]).add(prereq[0]);
            indegrees[prereq[0]]++;
        }


        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                q.offer(i);
            }
        }

        int[] order = new int[numCourses];
        int index = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            order[index++] = u;
            for (int v : graph.get(u)) {
                if (--indegrees[v] == 0) {
                    q.offer(v);
                }
            }
        }

        return index == numCourses ? order : new int[0];
    }


}
