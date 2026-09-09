class Solution {

// Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encode = new StringBuilder();
        for (String str : strs) {
            encode.append(str.length());
            encode.append('#');
            encode.append(str);
        } 
        return encode.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String str) {
        List<String> decodings = new LinkedList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (Character.isDigit(str.charAt(j))) j++;
            int size = Integer.valueOf(str.substring(i, j));
            i = j + 1 + size;
            decodings.add(str.substring(j + 1, i));
        }
        return decodings;
    }
}
