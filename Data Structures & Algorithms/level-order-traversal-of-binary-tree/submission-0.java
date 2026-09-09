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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) q.offer(root);

        int lvl = 1;
        List<List<Integer>> levels = new LinkedList<>();
        while(!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int newLevel = 0;
            List<Integer> order = new ArrayList<>();
            while (lvl-- != 0) {
                TreeNode curr = q.poll();
                if (curr.left != null) {
                    q.offer(curr.left);
                    newLevel++;
                } 
                if (curr.right != null) {
                    q.offer(curr.right);
                    newLevel++;
                }
                order.add(curr.val);
            }
            levels.add(order);
            lvl = newLevel;
        }
        return levels;
    }
}
