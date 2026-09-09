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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            sb.append(curr != null ? Integer.toString(curr.val) : 'N').append(',');
            if (curr == null) continue;
            q.offer(curr.left);
            q.offer(curr.right);
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        if (nodes[0].equals("N")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 0;
        while (i < nodes.length && !q.isEmpty()) {
            int size = q.size();
            while (i < nodes.length-1 && size-- > 0) {
                TreeNode curr = q.poll();
                if (!nodes[++i].equals("N")) {
                    curr.left = new TreeNode(Integer.valueOf(nodes[i]));
                    q.offer(curr.left);
                }
                if (!nodes[++i].equals("N")) {
                    curr.right = new TreeNode(Integer.valueOf(nodes[i]));
                    q.offer(curr.right);
                }
            }
        }
        return root;
    }
}

