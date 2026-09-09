class Solution {
    public List<List<String>> solveNQueens(int n) {
        // create the board
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        List<List<String>> ans = new ArrayList<>();
        backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), board, ans);
        return ans;
    }

    private void backtrack(int row, HashSet<Integer> columns, HashSet<Integer> posDiag, HashSet<Integer> negDiag, char[][] board, List<List<String>> ans) {
        if (row == board.length) {
            List<String> copy = new ArrayList<>();
            for (char[] r : board) {
                copy.add(new String(r));
            }
            ans.add(copy);
        }

        // go through each column and place a queen
        for (int col = 0; col < board.length; col++) {
            if(columns.contains(col) || posDiag.contains(col + row) || negDiag.contains(col - row)) 
                continue;

            columns.add(col);
            posDiag.add(col + row);
            negDiag.add(col - row);

            board[row][col] = 'Q';
            backtrack(row  + 1, columns, posDiag, negDiag, board, ans);
            board[row][col] = '.';

            columns.remove(col);
            posDiag.remove(col + row);
            negDiag.remove(col - row);
        } 
    }
}

// use hash set to check if a queen has been placed in:
// 1) positive diagonal
// 2) negative diagonal
// 3) column 
// base case: you've reached row out of bounds or you youre in a spot where a queen in a diagonal or column exists
// back track:
// at every position in the row we check if we can place a queen if we can then we move to the next