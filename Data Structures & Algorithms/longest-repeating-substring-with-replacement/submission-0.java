class Solution {
    // Note: you can find the number of replacements in the sliding window by
    // keeping track of the most frequent character and subtracting the length
    // of the window and the count of the most frequent character
    public int characterReplacement(String s, int k) {
        int[] map = new int[26];
        int majority = 0, l = 0, max = 0, len = s.length();
        for (int i = 0; i < len; i++) {
            majority = Math.max(majority, ++map[s.charAt(i) - 'A']);
            while (i - l + 1 - majority > k) map[s.charAt(l++) - 'A']--;
            max = Math.max(max, i - l + 1);
        }
        return max;
    }
}
