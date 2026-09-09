class Solution {
    public boolean isPalindrome(String s) {
        int lo = 0, hi = s.length()-1;
        while (lo < hi) {
            // if hi or lo is a space skip it 
            while (lo < hi && !Character.isLetterOrDigit(s.charAt(lo))) {
                lo++;
            }

            while (lo < hi && !Character.isLetterOrDigit(s.charAt(hi))) {
                hi--;
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
