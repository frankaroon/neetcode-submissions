/*
1) use union find
2) border cells and inner cells are placed in different sets
3) we will use a dummy node connected to border set as a point of reference 
*/

class Solution {
    public void solve(char[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;
        DSU uf = new DSU(ROWS*COLS + 1);
        
        // go through the entire board and start joining the sets
        int[][] DIRECTIONS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] != 'O') continue;
                if (i == 0 || j == 0 || i == ROWS - 1 || j == COLS -1) {
                    uf.union(ROWS*COLS, i * COLS + j);
                } else {
                    for (int[] d : DIRECTIONS) {
                        int nr = i + d[0];
                        int nc = j + d[1];
                        if (board[nr][nc] == 'O') {
                            uf.union(i * COLS + j, nr * COLS + nc);
                        }
                    }
                }
            }
        }

        // check what is not connected to a border
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (!uf.isConnected(ROWS*COLS, i * COLS + j)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}

class DSU {
    int[] parent;
    int[] size;

    public DSU (int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

public int find(int x) {
    if (parent[x] != x) 
        parent[x] = find(parent[x]);
    return parent[x];
}

    boolean union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (ra == rb) return false;

        if (size[ra] < size[rb]) {
            int tmp = ra; ra = rb; rb = tmp;
        }
        parent[rb] = ra;
        size[ra] += size[rb];
        return true;
    }

    public boolean isConnected(int u, int v) {
        return find(u) == find(v);
    }
}
