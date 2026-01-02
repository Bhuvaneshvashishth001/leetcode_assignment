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
    public static void dfs(Node node,Node visited[],Node clone){
        visited[clone.val] = clone;
        for(Node n:node.neighbors){
            if(visited[n.val] == null){
                Node newNode = new Node(n.val);
                clone.neighbors.add(newNode);
                dfs(n,visited,newNode);
            }
            else{
                clone.neighbors.add(visited[n.val]);
            }
        }
    }
    public Node cloneGraph(Node node) {
        if(node == null){
            return node;
        }
        Node clone = new Node(node.val);
        Node visited[] = new Node[101];
        Arrays.fill(visited,null);
        dfs(node,visited,clone);
        return clone;
    }
}