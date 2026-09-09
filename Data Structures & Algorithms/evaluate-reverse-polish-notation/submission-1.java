class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (!"+-*/".contains(token)) {
                stack.push(Integer.parseInt(token));
                continue;
            } 

            int n2 = stack.pop();
            int n1 = stack.pop();
            int res = 0;

            switch (token) {
                case "+":
                    stack.push(n1+n2);
                    break;
                case "-":
                    stack.push(n1-n2);
                    break;
                case "/":
                    stack.push(n1/n2);
                    break;
                case "*":
                    stack.push(n1*n2);
                    break;
            }
        }

        return stack.pop();
    }
}
