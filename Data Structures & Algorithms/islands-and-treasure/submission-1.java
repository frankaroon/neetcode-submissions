class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];

            for (int[] d : directions) {
                int nr = row + d[0];
                int nc = col + d[1];

                if (
                    !isInBound(nr, nc, grid.length, grid[0].length) || 
                    grid[nr][nc] != Integer.MAX_VALUE 
                ) {
                    continue;
                }

                grid[nr][nc] = grid[row][col] + 1;
                q.add(new int[]{nr, nc});
            }

        }
    }

    private boolean isInBound(int row, int col, int maxRow, int maxCol) {
        return (row >= 0 && row < maxRow && col >= 0 && col < maxCol);
    }
}
