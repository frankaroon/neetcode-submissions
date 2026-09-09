class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] alphabetFreq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabetFreq[s.charAt(i) - 'a']++;
            alphabetFreq[t.charAt(i) - 'a']--;
        }


        for (int freq : alphabetFreq) {
            if (freq != 0) return false;
        }

        return true;
    }
}
