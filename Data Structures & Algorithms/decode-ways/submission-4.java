class Solution {
    public int numDecodings(String s) {
        int memo = 0, memo2 = 0;
        int memo1 = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                memo = 0;
            } else {
                memo = memo1;
                if (i + 1 < s.length() && 
                    (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                        memo += memo2;
                }
            }

            memo2 = memo1;
            memo1 = memo;
            memo = 0;
        }

        return memo1;
    }
}
