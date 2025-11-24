class Solution {
    public int[] findOrder(int V, int[][] edges) {
        int order[]  = new int[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        int indegree[] = new int[V];
        for(int edge[]:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u);
            indegree[u]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int count =0;
        int j=0;
        for(int i=0;i<V;i++){
            if(indegree[i] ==0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            order[j++] = node;
            count++;
            for(int ele:adj.get(node)){
                indegree[ele]--;
                if(indegree[ele] ==0){
                    queue.offer(ele);
                }
            }
        }
        if(count != V){
            return new int[0];
        }
        return order;
    }
}