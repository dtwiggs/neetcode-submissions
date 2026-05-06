class Solution {
    HashMap<Node, Node> cloneMap = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null){
            return node;
        } else if(node.neighbors.isEmpty()){
            return new Node();
        }

        return cloneGraphRec(node);
    }

    private Node cloneGraphRec(Node node){
        Node clone = new Node(node.val);
        cloneMap.put(node, clone);

        for(Node next : node.neighbors){
            if(cloneMap.containsKey(next)){
                clone.neighbors.add(cloneMap.get(next));
            } else{
                clone.neighbors.add(cloneGraphRec(next));
            }
        }
        return clone;
    }
}