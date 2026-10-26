class Solution {
    Boolean[][] memo;
    public boolean isInterleave(String s1, String s2, String s3) {
        int N = s1.length(), M = s2.length();
        if (N + M != s3.length()) {
            return false;
        }

        memo = new Boolean[N+1][M+1];
        return dfs(0, 0, s1, s2, s3);
    }

    private boolean dfs(int i, int j, String s1, String s2, String s3) {
        int N = s1.length(), M = s2.length();
        if (i == N && j == M) {
            return true;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }


        boolean possible = false;
        if (i < N && s1.charAt(i) == s3.charAt(i+j)) {
            possible |= dfs(i+1, j, s1, s2, s3);
        }

        if (j < M && s2.charAt(j) == s3.charAt(i+j)) {
            possible |= dfs(i, j+1, s1, s2, s3);
        }

        return memo[i][j] = possible; 
    }
}

/* 
1) Parameters
    i - keeps track of string s1
    j - keeps track of string s2

2) base case
    if i is at the end of its respective string
        return append the rest of j's string and compare to s3
    if j is at the end of its respective string
        return append the rest of i's string and compare to s3
    if i or j charAt does not equal the next charAt(i+j) of s3 return false;

3) recurrence relation
    if (s1(j) == s3(i+j))
        recurse(j+1)
    if (s1(i) == s3(i+j))
        recurse(j+1)
*/