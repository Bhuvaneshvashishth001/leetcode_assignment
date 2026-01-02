class Solution {
    class Pair{
        int node;
        int weight;
        public Pair(int node,int weight){
            this.node = node;
            this.weight = weight;
        }
    }
    public int[] minimumTime(int n, int[][] edges, int[]vanish) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[]:edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        int dist[] =new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b)->a.weight-b.weight);
        dist[0] = 0;
        queue.add(new Pair(0,0));
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int v = p.node;
            int w = p.weight;
            if(w>dist[v]){
                continue;
            }
            for(Pair it:adj.get(v)){
                if(dist[it.node]>w+it.weight){
                    if(w+it.weight<vanish[it.node]){
                        dist[it.node] = w+it.weight;
                        queue.add(new Pair(it.node,dist[it.node]));
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] =-1;
            }
        }
        return dist;
    }
}