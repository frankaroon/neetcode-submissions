class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] a1 = new int[26];
        for (char c : s1.toCharArray()) {
            a1[c - 'a']++;
        }

        int[] a2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            a2[s2.charAt(i) - 'a']++;
        }

        int lo = 0, hi = s1.length()-1;
        while (hi < s2.length()) {
            if (match(a1, a2)) {
                return true;
            }

            if (hi == s2.length() - 1) break;
            a2[s2.charAt(lo++)-'a']--;
            a2[s2.charAt(++hi)-'a']++;
        }
        return false;
    }

    public boolean match(int[] a1, int[] a2) {
        for (int i = 0; i < 26; i++) {
            if (a1[i] != a2[i]) return false;
        }
        return true;
    }
}
