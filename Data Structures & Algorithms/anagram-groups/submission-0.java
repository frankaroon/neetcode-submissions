class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String key = getKey(s);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }

        return new ArrayList(map.values());
    }

    private String getKey(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) map[c - 'a']++;

        StringBuilder sb = new StringBuilder();
        for (int freq : map){
            sb.append('#');
            sb.append(freq);
        }
        return sb.toString();
    }
}
