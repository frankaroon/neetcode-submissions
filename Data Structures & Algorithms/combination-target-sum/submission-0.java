class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {     
        backtrack(0, target, nums, new ArrayList<>());
        return ans;
    }

    public void backtrack(int i, int target, int[] nums, List<Integer> curr) {
        if (target < 0 || i == nums.length) {
            return;
        }

        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        // left subtree
        curr.add(nums[i]);
        backtrack(i, target - nums[i], nums, curr);
        curr.remove(curr.size() - 1);

        // right subtree
        backtrack(i + 1, target, nums, curr);
    }
}
