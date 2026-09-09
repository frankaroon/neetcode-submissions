class Solution {
    // Time: O(n) space O(1)
    public int maxProfit(int[] prices) {
        int max = 0, l = 0;
        for (int r = 1; r < prices.length; r++) {
            if (prices[r] > prices[l]) {
                max = Math.max(max, prices[r] - prices[l]);
            } else {
                l = r;
            }
        }
        return max;
    }
    // notes: similar to the brute force solution we start with i and j next to each other
    // and we only increment i to equal r when 

    // Brute Force ->  time: O(n^2) space O(1) 
    // public int maxProfit(int[] prices) {
    //     int max = 0;
    //     for (int i = 0; i <  prices.length - 1; i++) {
    //         for (int j = i + 1; j < prices.length; j++) {
    //             max = Math.max(max, prices[j] - prices[i]);
    //         }
    //     }
    //     return max;
    // }
}

