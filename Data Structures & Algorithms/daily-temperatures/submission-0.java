class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && stack.peek()[0] < temperatures[i]) {
                int[] tmp = stack.pop();
                res[tmp[1]] = i - tmp[1];
            }

            stack.push(new int[]{temperatures[i], i});
        }

        return res;
    }
}
