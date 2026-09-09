class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(0, 0, new StringBuilder(), ans, n);
        return ans;
    }

    public void backtrack(int open, int closed, StringBuilder curr, List<String> ans, int n) {
        if (open == n && closed == n) {
            ans.add(curr.toString());
            return;
        }


        if (open < n) {
            curr.append('(');
            backtrack(open + 1, closed, curr, ans, n);
            curr.deleteCharAt(curr.length() - 1);
        }

        if (open > closed) {
            curr.append(')');
            backtrack(open, closed + 1, curr, ans, n);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}