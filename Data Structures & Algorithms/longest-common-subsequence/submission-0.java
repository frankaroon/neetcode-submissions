class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length(); 
        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1], Math.max(dp[i][j-1], dp[i-1][j]));
                }
            }
        }
        return dp[m][n];
    }
}




/*

CAT CRABT

   "" c r a b t
""  0 0 0 0 0 0
c   0 1 1 1 1 1
a   0 1 1 2 2 2  
t   0 

Recurrence relation
i -> position of text 1
j -> position of text 2 

DP(i, j) = 
    1) if letters = -> 1 + DP(i-1, j-1) fill out row with value and move to the next
    2) if letters != -> max(DP(i-1, j), DP(i, j-1), DP(i-1, j-1))

*/