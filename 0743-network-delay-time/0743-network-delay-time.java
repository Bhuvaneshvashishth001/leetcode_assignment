class Solution {
    class Pair{
        int node;
        int dis;
        public Pair(int node,int dis){
            this.node = node;
            this.dis = dis;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[]:times){
            int u =edge[0]-1;
            int v = edge[1]-1;
            int w = edge[2];
            adj.get(u).add(new Pair(v,w));
        }
        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k-1] =0;
        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b)->a.dis-b.dis);
        queue.add(new Pair(k-1,0));
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int v = p.node;
            int d = p.dis;
            for(Pair it:adj.get(v)){
                if(dist[it.node]>it.dis+d){
                    dist[it.node]  = it.dis+d;
                    queue.add(new Pair(it.node,dist[it.node]));
                }
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            if(dist[i]== Integer.MAX_VALUE){
                return -1;
            }
            else{
                ans= Math.max(ans,dist[i]);
            }
        }
        return ans;
    }
}