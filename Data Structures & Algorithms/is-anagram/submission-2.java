class Solution {
    public boolean isAnagram(String s, String t) {
        int size = s.length();
        if (size != t.length()) return false;
        
        int[] map = new int[26];
        for (int i = 0; i < size; i++) {
            map[s.charAt(i)-'a']++;
            map[t.charAt(i)-'a']--;
        }

        for (int character : map) {
            if (character != 0) return false;
        }

        return true;
    }
}
