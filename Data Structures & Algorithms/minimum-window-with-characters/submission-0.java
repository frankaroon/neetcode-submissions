// class Solution {
//     // 1) we expand the right pointer until we have all the characters in T
//     // 2) increment the left pointer and we get a smaller window
//     // if at only point we dont have all the characters in T anymore then we
//     // repeat step 2 
//     public String minWindow(String s, String t) {
//         int len = s.length();
//         if (t.length() > len) return "";
//         Map<Character, Integer> sFreq = new HashMap<>();
//         for (char c : s.toCharArray()) {
//             sFreq.put(c, sFreq.getOrDefault(c, 0) + 1);
//         }

//         int matched = 0;
//         int left = 0, right = 0;
//         while (right < len) {
//             right++;
//         }
//         return "";
//     }
// }

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char x : t.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int matched = 0;
        int start = 0;
        int minLen = s.length() + 1;
        int subStr = 0;
        for (int endWindow = 0; endWindow < s.length(); endWindow++) {
            char right = s.charAt(endWindow);
            if (map.containsKey(right)) {
                map.put(right, map.get(right) - 1);
                if (map.get(right) == 0) matched++;
            }

            while (matched == map.size()) {
                if (minLen > endWindow - start + 1) {
                    minLen = endWindow - start + 1;
                    subStr = start;
                }
                char deleted = s.charAt(start++);
                if (map.containsKey(deleted)) {
                    if (map.get(deleted) == 0) matched--;
                    map.put(deleted, map.get(deleted) + 1);
                }
            }
        }
        return minLen > s.length() ? "" : s.substring(subStr, subStr + minLen);
    }
}