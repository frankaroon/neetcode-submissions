class Solution {
    public boolean isPalindrome(String s) {
        int lo = 0, hi = s.length()-1;
        while (lo < hi) {
            if (!Character.isLetterOrDigit(s.charAt(lo))) {
                lo++;
                continue;
            }

            if (!Character.isLetterOrDigit(s.charAt(hi))) {
                hi--;
                continue;
            }

            System.out.println(s.charAt(lo) + " " + s.charAt(hi));
            if (Character.toLowerCase(s.charAt(lo)) != Character.toLowerCase(s.charAt(hi))) {
                return false;
            }

            lo++;
            hi--;
        }

        return true;
    }
}
