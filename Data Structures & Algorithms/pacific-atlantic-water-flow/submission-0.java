class Solution {
    int[][] DIRECTIONS = new int[][]{{1,0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length; int COLS = heights[0].length;
        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];

        // top + bottom border
        for (int c = 0; c < COLS; c++) {
          dfs(0, c, pacific, heights);
          dfs(ROWS - 1, c, atlantic, heights);
        }

        // left + right border
        for (int r = 0; r < ROWS; r++) {
          dfs(r, 0, pacific, heights);  
          dfs(r, COLS - 1, atlantic, heights);
        }

        // the intersection between two sets is the answer
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    private void dfs(int row, int col, boolean[][] visitedLand, int[][] heights) {
        visitedLand[row][col] = true;
        for (int[] d : DIRECTIONS) {
            int nextRow = row + d[0];
            int nextCol = col + d[1];
            if (isInBounds(nextRow, nextCol, heights) && !visitedLand[nextRow][nextCol] && heights[row][col] <= heights[nextRow][nextCol]) 
                dfs(nextRow, nextCol, visitedLand, heights);
        }
    }

    private boolean isInBounds(int row, int col, int[][] heights) {
        return row >= 0 && row < heights.length && col >= 0 && col < heights[0].length;
    }
}

/*

1. ask clarifying questions

    what happens when two heights are the same?
    what are the height constraints and ranges?
    how big can the grid be?

2. Design an Algorithm 
    DFS/Backtracking - naive solution

    we have to reverse the thinking here

    A cell can reachy an ocean if water can flow from that cell to the ocean,
    with this logic we start from the ocean borders, and dont have to recurse 
    in the middle of the grid keep track of all the positions that are visited

    do 2 DFS runs
     1. pacific - top row + left column
     2. atlantic - bottom row + right column

    keep track of all visited nodes in hashset

3. psuedo code
    
    pass through all borders on grid and and dfs on those cells
    build a helper function that keeps track of grid, position, and if it reaches both  

    dfs(heights, row, column): 
        // base cases
        out of bounds for row and col
        if cell has already been visited

        // recursive step
        mark current position as visited
        recurse on all neighbors with a lower or equal height
*/