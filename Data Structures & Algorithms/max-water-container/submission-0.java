class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            if (heights[right] <= heights[left]) {
                // right - 1, when right height is smaller than left
                max = Math.max(max, heights[right]*(right-left));
                right--;
            } else {
                // vice versa
                max = Math.max(max, heights[left]*(right-left));
                left++;
            }
        }   

        return max;
    }
}
