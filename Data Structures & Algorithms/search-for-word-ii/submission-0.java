class Solution {
    public static int[][] DIRECTIONS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        int n = board.length;
        int m = board[0].length;

        TrieNode root = new TrieNode();
        for (String word : words) {
            root.add(word);
        }

        List<String> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                TrieNode nextNode = root.letters[board[i][j] - 'a'];
                if (nextNode != null) 
                    dfs(board, ans, root, i, j);
            }
        } 

        return new ArrayList<>(ans); 
    }

    private void dfs(char[][] board, List<String> ans, TrieNode root, int row, int col) {
        char saved = board[row][col];
        if (saved == '#') return;
        
        int i = saved - 'a';
        TrieNode child = root.letters[i];

        if (child == null) return;

        if (child.word != null) {
            ans.add(child.word);
            child.word = null;
        }

        board[row][col] = '#';
        for (int[] d : DIRECTIONS) {
            int nr = row + d[0];
            int nc = col + d[1];
            if (isLegalMove(board, nr, nc) && board[nr][nc] != '#') {
                int nextIdx = board[nr][nc] - 'a';
                if (child.letters[nextIdx] != null) dfs(board, ans, child, nr, nc);
            }
        }

        board[row][col] = saved;
        if (child.isLeafNode()) {
            root.letters[i] = null;
        }
    }

    private boolean isLegalMove(char[][] board, int row, int col) {
      return (row >= 0 && row < board.length && col >= 0 && col < board[0].length);
    }
}

class Trio {
    int row;
    int col;
    TrieNode node;

    public Trio(int row, int col, TrieNode node) {
        this.row = row;
        this.col = col;
        this.node = node;
    }
} 

class TrieNode {
    String word = null;
    TrieNode[] letters = new TrieNode[26];

    public void add(String word) {
        TrieNode curr = this;
        for (char c : word.toCharArray()) {
            if (curr.letters[c - 'a'] == null) {
                curr.letters[c - 'a'] = new TrieNode();
            }
            curr = curr.letters[c - 'a'];
        }

        curr.word = word;
    }

    public boolean isLeafNode() {
        for (TrieNode node : letters) {
            if (node != null) return false;
        }

        return true;
    }
}

// I had two problems 

// for my backtracking I had to unvisit a node when pop off the stack and I wasnt doing that
// forgetting that the root of a trie isnt an actual letter
// optimization includes pruning 