class Solution {
    public boolean canFinish(int V,int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        int indegree[] = new int[V];
        for(int edge[] :edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u);
            indegree[u]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int visited[] = new int[V];
        for(int i=0;i<V;i++){
            if(indegree[i] == 0){
                queue.offer(i);
                visited[i] = 1;
            }
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            visited[node] =1;
            for(int ele:adj.get(node)){
                indegree[ele]--;
                if(indegree[ele] == 0){
                    queue.offer(ele);
                }
            }
        }
        for(int i=0;i<V;i++){
            if(visited[i] == 0){
                return false;
            }
        }
        return true;
    }
}