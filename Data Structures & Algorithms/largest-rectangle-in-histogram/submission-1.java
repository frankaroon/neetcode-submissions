class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Pair> stack = new ArrayDeque<>();
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek().height > heights[i]) {
                Pair top = stack.pop();
                int index = top.index, height = top.height;
                max = Math.max(max, height*(i-index));
                start = index;
            }
            stack.push(new Pair(start, heights[i]));
        }

        for (Pair pair : stack) {
            int index = pair.index;
            int height = pair.height;
            max = Math.max(max, height * (heights.length - index));
        }
        return max;
    }
}

class Pair {
    int index;
    int height;

    public Pair(int index, int height) {
        this.index = index;
        this.height = height;
    }
}
