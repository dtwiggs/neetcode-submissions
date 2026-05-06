class Solution {
    HashMap<Node, Node> map;

    public Node cloneGraph(Node node) {
        if(node == null){
            return node;
        } else if(node.neighbors.isEmpty()){
            return new Node(node.val);
        }

        map = new HashMap<>();

        return dfs(node);
    }

    /*
        Map node 1
        dfs(node 2)
        node2.add(node 1)
        Map node 2
        dfs(node 3)
        node3.add(node 2)
        Map node 3

    */

    private Node dfs(Node node){
        Node clone = new Node(node.val);
        map.put(node, clone);

        for(Node tmp : node.neighbors){
            if(!map.containsKey(tmp)){
                clone.neighbors.add(dfs(tmp));
            } else{
                clone.neighbors.add(map.get(tmp));
            }
        }
        return clone;
    }
}

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