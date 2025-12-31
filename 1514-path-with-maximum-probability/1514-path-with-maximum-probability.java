class Solution {
    class Pair{
        int node;
        double w;
        public Pair(int node,double w){
            this.node = node;
            this.w = w;
        }
    } 
    public double maxProbability(int n, int[][] edges, double[] succ, int start, int end) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int j=0;
        for(int edge[]:edges){
            int u = edge[0];
            int v = edge[1];
            double w = succ[j];
            adj.get(u).add(new Pair(v,w)); 
            adj.get(v).add(new Pair(u,w)); 
            j++;
        }
        double dist[] = new double[n];
        Arrays.fill(dist,0.0);
        dist[start] = 1.0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(start,1.0));
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int k = p.node;
            double dis = p.w;
            if(dist[k]>dis){
                continue;
            }
            for(Pair it:adj.get(k)){
                if(dist[it.node]<it.w*dis){
                    dist[it.node] = it.w*dis;
                    queue.add(new Pair(it.node,it.w*dis));
                }
            }
        }
        return dist[end];
    }
}