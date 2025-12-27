class Solution {
    class Pair{
        int node;
        int time;
        public Pair(int node,int time){
            this.node = node;
            this.time = time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[]:times){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new Pair(v,w));
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b)->a.time-b.time);
        int dist[] = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        queue.add(new Pair(k,0));
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int des = p.node;
            int t = p.time; 
            for(Pair it:adj.get(des)){
                if(dist[it.node] > (t+it.time)){
                    dist[it.node] = t+it.time;
                    queue.add(new Pair(it.node,t+it.time));
                }
            }
        }
        int ans = 0;
        for(int i=1;i<n+1;i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max(dist[i],ans);
        }
        return ans;
    }
}