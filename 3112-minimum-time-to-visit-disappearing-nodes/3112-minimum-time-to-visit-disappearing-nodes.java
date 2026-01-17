class Solution {
    class Pair{
        int node;
        int time;
        public Pair(int node,int time){
            this.node = node;
            this.time = time;
        }
    }
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[]:edges){
            int u = edge[0];
            int v = edge[1];
            int t = edge[2];
            adj.get(u).add(new Pair(v,t));
            adj.get(v).add(new Pair(u,t));
        }
        int time[] = new int[n];
        Arrays.fill(time,Integer.MAX_VALUE);
        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b)->a.time-b.time);
        time[0] = 0;
        queue.add(new Pair(0,0));
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int node = p.node;
            int hr = p.time;
            if(time[node]<hr){
                continue;
            }
            for(Pair it:adj.get(node)){
                if(time[it.node]> hr+it.time){
                    if(hr+it.time < disappear[it.node]){
                        time[it.node] = hr+it.time;
                        queue.add(new Pair(it.node,hr+it.time));
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            if(time[i] == Integer.MAX_VALUE){
                time[i] =-1;
            }
        }
        return time;
    }
}