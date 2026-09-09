class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        dfs(0, new ArrayList<>(), nums, subsets);
        return subsets;
    }

    public void dfs(int index, List<Integer> subset, int[] nums, List<List<Integer>> subsets) {
        if (index >= nums.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }

        dfs(index + 1, subset, nums, subsets);
        subset.add(nums[index]);
        dfs(index + 1, subset, nums, subsets);
        subset.remove(subset.size() - 1);
    }
}