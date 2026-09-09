class Solution {
    // int[] dp = new int[40]; 
    // public int climbStairs(int n) {
    //     if (n < 0) {
    //         return 0;
    //     } else if (n == 0) {
    //         return 1;
    //     }

    //     if (dp[n] != 0) {
    //         return dp[n];
    //     }

    //     return dp[n] = climbStairs(n-1) + climbStairs(n-2);
    // }

    public int climbStairs(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
