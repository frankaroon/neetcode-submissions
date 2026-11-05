class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        List<Integer> res = new ArrayList<>();
        for (int m = 0; m < (Math.min(rows, cols) + 1) / 2; m++) {
            int top = m;
            int bottom = rows - 1 - m;
            int right = cols - 1 - m;
            int left = m; 

            // single row left: walk it once, left to right   // added
            if (top == bottom) {
                for (int i = left; i <= right; i++) {
                    res.add(matrix[top][i]);
                }
                break;
            }

            // single column left: walk it once, top to bottom   // added
            if (left == right) {
                for (int i = top; i <= bottom; i++) {
                    res.add(matrix[i][left]);
                }
                break;
            }

            // top 
            for (int i = top; i < right; i++) {
                res.add(matrix[top][i]);
            }

            // right
            for (int i = top; i < bottom; i++) {
                res.add(matrix[i][right]);
            }

            // bottom
            for (int i = right; i > left; i--) {
                res.add(matrix[bottom][i]);
            }

            //left 
            for (int i = bottom; i > top; i--) {
                res.add(matrix[i][left]);
            }
        }
        return res;
    }
}
