class Solution {
    int[][] directions = new int[][]{{1,0}, {0,1}, {-1,0}, {0, -1}};

    public int numIslands(char[][] grid) {
        int islands = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j, visited, grid);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void dfs(int row, int col, boolean[][] visited, char[][] grid) {
        visited[row][col] = true;

        for (int[] direction : directions) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];

            if (isInBounds(nextRow, nextCol, grid) && grid[nextRow][nextCol] == '1' && !visited[nextRow][nextCol]) {
                dfs(nextRow, nextCol, visited, grid);
            }
        }
    }

    private boolean isInBounds(int row, int col, char[][] grid) {
        return row >= 0 && row < grid.length && col < grid[0].length && col >= 0;
    }
}
