class Solution {
    // 1) we expand the right pointer until we have all the characters in T
    // 2) increment the left pointer and we get a smaller window
    // if at only point we dont have all the characters in T anymore then we
    // repeat step 2 
    //
    // keeping track of the characters in T in constant time is possible
    // with an integer variable "match". "match" is incremented when you 
    // reach the character frequency and decremented when it falls below 
    // the character frequency in T. We then compare "match" to the number
    // of unique characters in the map which is map.size()
    public String minWindow(String s, String t) {
        int len = s.length();
        if (t.length() > len) return "";
        Map<Character, Integer> tFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        int[] ans = new int[]{s.length() + 1, 0 ,0}; // [length, leftPtr, rightPtr]
        int matched = 0, left = 0, right = 0;
        while (right < len) {
            char c = s.charAt(right);
            if (tFreq.containsKey(c)) {
                tFreq.put(c, tFreq.get(c)-1);
                if (tFreq.get(c) == 0) matched++;
            }

            while (matched == tFreq.size()) {
                if (ans[0] > right - left) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                
                char deleted = s.charAt(left);
                if (tFreq.containsKey(deleted)) {
                    tFreq.put(deleted, tFreq.get(deleted) + 1);
                    if (tFreq.get(deleted) > 0) matched--;
                }
                left++;
            }
            right++;
        }
        return ans[0] == s.length() + 1 ? "" : s.substring(ans[1], ans[2]+1);
    }
}
