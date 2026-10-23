class Solution {
    Integer[][] memo;

    public int maxProfit(int[] prices) {
        memo = new Integer[prices.length][2];
        return dfs(0, false, prices);
    }

    private int dfs(int day, boolean hasShares, int[] prices) {
        if (day >= prices.length) {
            return 0;
        }

        if (memo[day][hasShares ? 1 : 0] != null) {
            return memo[day][hasShares ? 1 : 0];
        }

        int maxProfit = 0;
        // buy or sell
        if (!hasShares) {
            // we are buying
            maxProfit = Math.max(maxProfit, dfs(day+1, true, prices) - prices[day]);
        } else {
            maxProfit = Math.max(maxProfit, dfs(day+2, false, prices) + prices[day]);
        }

        // cooldown
        maxProfit = Math.max(maxProfit, dfs(day+1, hasShares, prices));
        return memo[day][hasShares ? 1 : 0] = maxProfit;
    }
}



/*
you have two choices:
 a. buy/sell
 b. cooldown

 rules:
  1. you must cooldown for at least 1 day if you sell
  2. you can only have 1 share at a time


1) variables:
    day - keeps track of the day
    profit - total amount of profit made
    hasShares - boolean to check if you are buying or selling

if you sell make sure you jump to day + 2 bc of cooldown

2) base cases
    day >= prices.length
    return profit;

3) Reccurence relation
*/ 