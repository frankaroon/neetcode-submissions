class Solution {
    public int maxProfit(int[] prices) {
        int dp1 = 0;
        int dp2 = 0;
        int dp3 = 0;
        for (int i = prices.length-1; i >= 0; i--) {
            int tmp = dp2;
            dp2 = Math.max(dp1 - prices[i], dp2);
            dp1 = Math.max(dp3 + prices[i], dp1);
            dp3 = tmp;
        }

        return dp2;
    }
}

/*
you have two choices:
 a. buy/sell
 b. cooldown

 rules:
  1. you must cooldown for at least 1 day if you sell
  2. you can only have 1 share at a time

Bottom Up
1) variables:
    day - keeps track of the day
    profit - total amount of profit made
    hasShares - boolean to check if you are buying or selling

2) base cases:
    table will be 0 bc minimum profit is guaranteed 0

3) Recurrence Relation: best profit from day i onward
    T(i, false) = max(T(i+1, true) - prices[i], T(i+1, false)) => buy, or rest
    T(i, true) = max(T(i+2, false) + prices[i], T(i+1, true)) => sell + skip a day, or hold      


Top down
1) variables:
    day - keeps track of the day
    profit - total amount of profit made
    hasShares - boolean to check if you are buying or selling

if you sell make sure you jump to day + 2 bc of cooldown

2) base cases
    T(day, holding) = 0    if i >= n

3) Reccurence relation
    T(i, false) = max(T(i+1, true) - prices[i], T(i+1, false))
    T(i, true) = max(T(i+2, true) + prices[i], T(i+1, true))               

4) time and space: O(n) 
*/ 