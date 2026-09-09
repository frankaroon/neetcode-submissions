class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i-1], leftMax[i-1]);
            rightMax[height.length-i-1] = Math.max(height[height.length-i], rightMax[height.length-i]);
        }

        int totalWater = 0;
        for (int i = 0; i < height.length; i++) {
            totalWater += Math.max(Math.min(leftMax[i], rightMax[i]) - height[i], 0);
        }

        return totalWater;
    }
}
