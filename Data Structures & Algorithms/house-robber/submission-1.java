class Solution {
    int[] cache;
    public int rob(int[] nums) {
        cache = new int[nums.length];
        return Math.max(dfs(nums, 0), dfs(nums, 1));
    }

    private int dfs(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }

        if (cache[index] != 0) {
            return cache[index];
        }

        return cache[index] = Math.max(dfs(nums, index + 1), nums[index] + dfs(nums, index + 2));
    }
}
