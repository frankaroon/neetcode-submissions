class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int i = 0, j = 0, m = matrix.length, n = matrix[0].length;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[m][n];

        List<Integer> res = new ArrayList<>();
        while (res.size() < m*n) {
            for (int[] direction : directions) {
                while (true) {
                    if (!visited[i][j]) {
                        visited[i][j] = true;
                        res.add(matrix[i][j]);
                    }

                    int nextRow = i + direction[0]; 
                    int nextCol = j + direction[1];
                    if (isValid(nextRow, nextCol, m, n) && !visited[nextRow][nextCol]) {
                        i = nextRow;
                        j = nextCol;
                    } else {
                        break;
                    }
                }
            }
        }
        return res;
    }

    public boolean isValid(int i, int j, int m, int n) {
        return !(i < 0 ||  j < 0 || i >= m || j >= n);
    }
}
