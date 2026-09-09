class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // initialize graph
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        // build out the graph and indegrees
        for (int[] prereq : prerequisites) {
            graph.get(prereq[1]).add(prereq[0]);
            indegrees[prereq[0]]++;
        }


        // push all root nodes (0 indegrees) onto the q
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int course = q.poll();
            List<Integer> neighbors = graph.get(course);
            for (int neighbor : neighbors) {
                int indegree = --indegrees[neighbor];
                if (indegree == 0) {
                    q.offer(neighbor);
                }
            }
        }

        for (int indegree : indegrees) {
            if (indegree != 0) return false;
        }

        return true;
    }
}
