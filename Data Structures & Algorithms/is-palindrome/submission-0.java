class Solution {
    public boolean isPalindrome(String s) {
        int lo = 0, hi = s.length()-1;
        while (lo < hi && hi >= 0 && lo < s.length()) {
            // if hi or lo is a space skip it 
            if (!Character.isLetterOrDigit(s.charAt(lo))) {
                lo++;
                continue;
            }

            if (!Character.isLetterOrDigit(s.charAt(hi))) {
                hi--;
                continue;
            }

            //compare lo and hi
            char c1 = Character.toLowerCase(s.charAt(lo));
            char c2 = Character.toLowerCase(s.charAt(hi));
            if (c1 != c2) {
                return false;
            }

            //move the pointers
            lo++;
            hi--;
        }

        return true;
    }
}
