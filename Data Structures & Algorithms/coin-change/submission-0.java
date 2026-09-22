class Solution {
    public int coinChange(int[] coins, int amount) {
        int res = dfs(amount, new Integer[amount+1], coins);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int dfs (int amount, Integer[] dp, int[] coins) {
        if (amount < 0) {
            return Integer.MAX_VALUE;
        } else if (amount == 0) {
            return 0;
        }

        if (dp[amount] != null) return dp[amount];

        int fewest = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = dfs(amount - coin, dp, coins);
            if (sub != Integer.MAX_VALUE) {
                fewest = Math.min(fewest, sub+1);
            }
        }

        return dp[amount] = fewest;
    }
}
