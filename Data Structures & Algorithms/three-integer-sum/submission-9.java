class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        int prev = -1;
        for (int i = 0; i < nums.length - 2; i++, prev++) {
            if (!(prev < 0) && nums[prev] == nums[i])
                continue;

            int lo = i + 1, hi = nums.length-1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while (lo < hi && nums[lo] == nums[lo + 1])
                        lo++;
                    while (lo < hi && nums[hi] == nums[hi - 1])
                        hi--;
                }
                
                if (sum < 0) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return ans;
    }
}
