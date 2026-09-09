class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> squares = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char curr = board[i][j];
                if (curr == '.') continue;
                if (rows.getOrDefault(i, new HashSet<>()).contains(curr) || 
                    cols.getOrDefault(j, new HashSet<>()).contains(curr) || 
                    squares.getOrDefault((i / 3) * 3 + j / 3, new HashSet<>()).contains(curr)) 
                    return false;
                rows.computeIfAbsent(i, k -> new HashSet<>()).add(curr);
                cols.computeIfAbsent(j, k -> new HashSet<>()).add(curr);
                squares.computeIfAbsent((i / 3) * 3 + j / 3, k -> new HashSet<>()).add(curr);
            }
        }

        return true;
    }
}
