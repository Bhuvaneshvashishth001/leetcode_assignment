class Solution {
    class Pair{
        int node;
        int weight;
        public Pair(int node,int weight){
            this.node = node;
            this.weight = weight;
        }
    }
    public void dis(int src,ArrayList<ArrayList<Pair>> adj,int dist[]){
        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b)->a.weight-b.weight);
        queue.add(new Pair(src,0));
        dist[src] = 0;
        while(!queue.isEmpty()){
            Pair p =queue.poll();
            int v = p.node;
            int w = p.weight;
            if(w>dist[v]){
                continue;
            }
            for(Pair it:adj.get(v)){
                if(dist[it.node] > w+it.weight){
                    dist[it.node] = w+it.weight;
                    queue.add(new Pair(it.node,dist[it.node]));
                }
            }
        }
    }
    public int path(int src,int n ,int dist[],int ways[],ArrayList<ArrayList<Pair>> adj){
        if(src == n){
            return 1;
        }
        if(ways[src] != -1){
            return ways[src];
        }
        int MOD = 1000000007;
        long count =0;
        for(Pair p:adj.get(src)){
            if(dist[src]>dist[p.node]) {
                count += path(p.node,n,dist,ways,adj);
                count %= MOD;
            }
        }
        return ways[src] = (int)count;
    }
    public int countRestrictedPaths(int n, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[]:edges){
            int u = edge[0]-1;
            int v = edge[1]-1;
            int w = edge[2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dis(n-1,adj,dist);
        int ways[] = new int[n]; 
        Arrays.fill(ways, -1);
        path(0,n-1,dist,ways,adj);
        return ways[0];
    }
}