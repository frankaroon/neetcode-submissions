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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>(); 
        if (root != null) q.offer(root);
        List<Integer> rightNodes = new LinkedList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            TreeNode curr = null;
            while (size-- > 0) {
                curr = q.poll();
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
            rightNodes.add(curr.val);
        }
        return rightNodes;
    }
}