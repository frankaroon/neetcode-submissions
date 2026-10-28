class Solution {
    Integer[][] memo;
    int[][] DIRECTIONS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int longestIncreasingPath(int[][] matrix) {
        memo = new Integer[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                if (memo[i][j] == null) {
                    max = Math.max(max, dfs(i, j, matrix));
                }
            }
        }
        return max;
    }

    private int dfs(int i, int j, int[][] matrix) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        int max = 1;
        for (int[] d : DIRECTIONS) {
            int nr = i + d[0];
            int nc = j + d[1];
            if (isInbounds(nr, nc, matrix.length, matrix[0].length) && matrix[nr][nc] > matrix[i][j]) {
                max = Math.max(max, dfs(nr, nc, matrix) + 1);
            }
        }

        return memo[i][j] = max;
    }

    private boolean isInbounds(int i, int j, int n, int m) {
        return (i >= 0 && i < n && j >= 0 && j < m); 
    }
}

/*
Choices
up down left right

1) parameters/variables
i, j figure out the coordinates of the solution

2) base cases
Any cell with no larger neighbor

3) Recurrence relation
T(i, j) = 1 + max(T(r, c)) over neighbors (n, c) in bounds 
                            where matrix(r, c) > matrix(i, j)

*/