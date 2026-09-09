/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxPathSum(TreeNode root) {
        int[] maxPath = new int[]{root.val};
        dfs(root, maxPath);
        return maxPath[0];
    }

    public int dfs(TreeNode root, int[] maxPath) {
        if (root == null) return 0;
        int left = Math.max(dfs(root.left, maxPath), 0);
        int right = Math.max(dfs(root.right, maxPath), 0);
        maxPath[0] = Math.max(maxPath[0], left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
