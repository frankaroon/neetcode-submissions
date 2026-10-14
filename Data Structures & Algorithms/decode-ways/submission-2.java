class Solution {
    public int numDecodings(String s) {
        Integer[] dp = new Integer[s.length()];
        return dfs(0, 0, s, dp);
    }

    public int dfs(int idx, int num, String str, Integer[] dp) {
        if (num > 26) {
            return 0;
        }

        if (idx == str.length()) {
            return 1;
        }

        if (str.charAt(idx) == '0') {
            return 0;
        }

        if (dp[idx] != null) {
            return dp[idx];
        }

        int ways = 0;
        num = str.charAt(idx) - '0';
        ways = dfs(idx+1, num, str, dp);

        if (idx + 1 < str.length()) {
            num = num * 10 + (str.charAt(idx+1) - '0');
            ways += dfs(idx+2, num, str, dp);
        }

        return dp[idx] = ways;
    }
}
