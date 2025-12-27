class Solution {
    class Pair{
        int des;
        long time;
        public Pair(int des,long time){
            this.des = des;
            this.time = time;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }     
        for(int road[]:roads){
            int u = road[0];
            int v = road[1];
            int time = road[2];
            adj.get(u).add(new Pair(v,time));
            adj.get(v).add(new Pair(u,time));
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b)->Long.compare(a.time, b.time));
        int paths[] = new int[n];
        int ways[] = new int[n];
        long dest[] = new long[n];
        int MOD=1_000_000_007;
        Arrays.fill(dest,Long.MAX_VALUE);
        dest[0] = 0;
        ways[0] = 1;
        queue.add(new Pair(0,0));
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int node = p.des;
            long time = p.time;
            if(time>dest[node]){
                continue;
            }
            for(Pair it:adj.get(node)){
                long t = time+it.time;
                if(dest[it.des]> t){
                    dest[it.des] = t;
                    ways[it.des] = ways[node];
                    queue.add(new Pair(it.des,t));
                }
                else if(dest[it.des] == t){
                    ways[it.des] =(ways[it.des]+ways[node])%MOD;
                }
            }
        }
        return ways[n-1];
    }
}