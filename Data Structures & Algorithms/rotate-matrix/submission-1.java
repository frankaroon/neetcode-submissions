class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int last = n - 1 - layer;
            for (int col = layer; col < last; col++) {
                int top = matrix[layer][col];
                matrix[layer][col]       = matrix[n - 1 - col][layer]; // left   -> top
                matrix[n - 1 - col][layer] = matrix[last][n - 1 - col]; // bottom -> left
                matrix[last][n - 1 - col]  = matrix[col][last];         // right  -> bottom
                matrix[col][last]          = top;                       // top    -> right
            }
        }
    }
}