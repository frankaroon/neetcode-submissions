class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, 0, board, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int i, int j, int pos, char[][] board, String word) {
        if (pos == word.length()) {
            return true;
        }

        if (!isInBound(i, j, board.length, board[0].length) || word.charAt(pos) != board[i][j]) {
            return false;
        }

        board[i][j] = '#';
        boolean res = dfs(i + 1, j, pos + 1, board, word) ||
        dfs(i - 1, j, pos + 1, board, word) ||
        dfs(i, j + 1, pos + 1, board, word) ||
        dfs(i, j - 1, pos + 1, board, word);
        board[i][j] = word.charAt(pos);
        return res;
    }

    public boolean isInBound(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }
}
