class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, l = 0, len = s.length();
        int[] map = new int[128];
        for (int r = 0; r < len; r++) {
            while (map[s.charAt(r)] > 0) map[s.charAt(l++)]--;
            map[s.charAt(r)]++;
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}