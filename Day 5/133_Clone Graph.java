/*
// Definition for a Node.
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
        if(node == null) {
            return node;
        }
        
        HashMap<Integer, Node> map = new HashMap<>();
        Queue<Node> bfs = new LinkedList<>();
        Node clone = new Node(node.val);
        map.put(clone.val, clone);
        bfs.add(node);
        
        while(!bfs.isEmpty()) {
            Node top = bfs.poll();
            Node cur = map.get(top.val);
            for(Node n : top.neighbors) {
                if(!map.containsKey(n.val)) {
                    bfs.add(n);
                }
                map.putIfAbsent(n.val, new Node(n.val));
                cur.neighbors.add(map.get(n.val));
            }
        }
        
        return clone;
    }
}

/*
Sample Test Cases
=================
[[2,4],[1,3],[2,4],[1,3]]
[[]]
[]
[[2],[1]]
*/