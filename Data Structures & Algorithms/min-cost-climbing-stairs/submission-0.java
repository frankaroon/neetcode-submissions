class Solution {
    Integer[] dp;
    public int minCostClimbingStairs(int[] cost) {
        dp = new Integer[cost.length];
        return Math.min(dfs(cost, 0), dfs(cost, 1));
    }

    public int dfs(int[] cost, int stair) {
        if (stair >= cost.length) return 0;
        if (dp[stair] != null) return dp[stair]; 
        return dp[stair] = cost[stair] + Math.min(dfs(cost, stair + 1), dfs(cost, stair + 2));
    }
}
