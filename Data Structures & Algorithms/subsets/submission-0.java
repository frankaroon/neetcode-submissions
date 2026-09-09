class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        dfs(0, new ArrayList<>(), nums, subsets);
        return subsets;
    }

    public void dfs(int index, List<Integer> curr, int[] nums, List<List<Integer>> subsets) {
        if (index == nums.length) {
            subsets.add(new ArrayList<>(curr));
            return;
        }

        dfs(index+1, curr, nums, subsets);
        curr.add(nums[index]);
        dfs(index+1, curr, nums, subsets);
        curr.remove(curr.size()-1);
    }
}