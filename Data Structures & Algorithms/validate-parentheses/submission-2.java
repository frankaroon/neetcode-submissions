class Solution {
    public boolean isValid(String s) {
        Set<Character> open = Set.of('(', '{', '[');

        Stack<Character> stack = new Stack<>();
        int l = s.length();
        for (int i = 0; i < l; i++) {
            char curr = s.charAt(i);
            if (open.contains(curr)) {
                stack.push(curr);
                continue;
            }

            // else it is closed bracket
            if (stack.isEmpty()) return false;
            char top = stack.pop();
            if ((curr == ')' && top != '(') ||
                (curr == '}' && top != '{') ||
                (curr == ']' && top != '[')
            ) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
