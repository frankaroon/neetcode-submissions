class Solution {
    final static int[][] DIRECTIONS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int orangesRotting(int[][] grid) {
        Deque<int[]> q = new ArrayDeque<>();
        int fresh = 0;
        
        // initial queue for all the fruits
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        // layered bfs traversal
        if (fresh == 0) return 0;

        int minutes = -1;
        while (!q.isEmpty()) {
            int layer = q.size();

            while (layer-- > 0) {
                int[] point = q.poll();
                int row = point[0];
                int col = point[1];

                for (int[] d : DIRECTIONS) {
                    int nextRow = row + d[0];
                    int nextCol = col + d[1];

                    if (isInBounds(nextRow, nextCol, grid) && grid[nextRow][nextCol] == 1) {
                        grid[nextRow][nextCol] = 2;
                        fresh--;
                        q.offer(new int[]{nextRow, nextCol});
                    }
                }
            }

            minutes++;
        }

        return fresh != 0 ? -1 : minutes;
    }

    private boolean isInBounds(int row, int col, int[][] grid) {
        return row < grid.length && row >= 0 && col < grid[0].length && col >= 0;
    }
}

/* 
algorithm 
1) multi source BFS
2) start at all the rotten fruits first and queue them
3) bfs out from there and go to neighbors only with fresh fruit
4) to count the minutes use a layered traversal

*/
