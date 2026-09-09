class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        dfs(nums, new ArrayList<Integer>(), new HashSet<Integer>());
        return ans;
    }

    private void dfs(int[] nums, List<Integer> permutation, HashSet<Integer> visited) {
        if (visited.size() == nums.length) 
            ans.add(new ArrayList<>(permutation));
            
        for (int num : nums) {
            if (!visited.contains(num)) {
                permutation.add(num);
                visited.add(num);
                dfs(nums, permutation, visited);
            }
        }
        if (permutation.size() > 0){
            int removed = permutation.remove(permutation.size()-1);
            visited.remove(removed);
        }
    }
}