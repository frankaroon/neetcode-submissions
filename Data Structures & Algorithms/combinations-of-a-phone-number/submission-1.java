class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0){
            return new ArrayList<>();
        }
        List<String> results = new ArrayList<>();
        String[] dialLetters = new String[10];
        dialLetters[2] = "abc";
        dialLetters[3] = "def";
        dialLetters[4] = "ghi";
        dialLetters[5] = "jkl";
        dialLetters[6] = "mno";
        dialLetters[7] = "pqrs";
        dialLetters[8] = "tuv";
        dialLetters[9] = "wxyz";
        dfs(0, new StringBuilder(), digits, dialLetters, results);
        return results;
    }

    private void dfs(int i, StringBuilder str, String digits, String[] dialLetters, List<String> results) {
        if (i >= digits.length()) {
            results.add(str.toString());
            return;
        }

        for (char c : dialLetters[digits.charAt(i) - '0'].toCharArray()) {
            str.append(c);
            dfs(i+1, str, digits, dialLetters, results);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
