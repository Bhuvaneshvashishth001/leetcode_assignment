class Solution {
    class Pair{
        int node;
        int weight;
        public Pair(int node,int weight){
            this.node = node;
            this.weight = weight;
        }
    }
    public int minCost(int n, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[]:edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,2*w));
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b)->a.weight-b.weight);
        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        queue.add(new Pair(0,0));
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int v = p.node;
            int dis = p.weight;
            if(dis>dist[v]){
                continue;
            }
            for(Pair it:adj.get(v)){
                if(dist[it.node] > dis+it.weight){
                    dist[it.node] = dis+it.weight;
                    queue.add(new Pair(it.node,dis+it.weight));
                }
            }
        }
        return dist[n-1] ==Integer.MAX_VALUE?-1:dist[n-1];
    }
}