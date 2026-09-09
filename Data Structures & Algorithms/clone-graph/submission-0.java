/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> clones = new HashMap<>();
        return dfs(node, clones);
    }

    private Node dfs(Node root, HashMap<Node, Node> clones) {
        if (root == null) return null;

        // grab current new node
        if (clones.containsKey(root)) {
            return clones.get(root);
        }

        Node curr = new Node(root.val);
        clones.put(root, curr);

        // go through neighbors
        for (Node neighbor : root.neighbors) {
            Node newNeighbor = dfs(neighbor, clones);
            curr.neighbors.add(newNeighbor);
        }

        return curr;
    }
}

// dfs pattern
// for each node we visit it store check if we have already visited it
// if we have not visited we will create it and update its neighbors and store it
// if we have visited the node we will access it and 


