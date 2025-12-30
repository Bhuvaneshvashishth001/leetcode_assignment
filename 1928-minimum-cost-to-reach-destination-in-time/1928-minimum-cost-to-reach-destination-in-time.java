class Solution{
    class Pair{
        int v,t,c;
        Pair(int v,int t,int c){
            this.v=v;
            this.t=t;
            this.c=c;
        }
    }
    public int minCost(int maxTime,int[][] edges,int[] fee){
        int n=fee.length;
        List<List<Pair>> g=new ArrayList<>();
        for(int i=0;i<n;i++)g.add(new ArrayList<>());
        for(int[] e:edges){
            g.get(e[0]).add(new Pair(e[1],e[2],0));
            g.get(e[1]).add(new Pair(e[0],e[2],0));
        }
        int[][] dist=new int[n][maxTime+1];
        for(int i=0;i<n;i++)Arrays.fill(dist[i],Integer.MAX_VALUE);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{fee[0],0,0});
        dist[0][0]=fee[0];

        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int cost=cur[0],u=cur[1],time=cur[2];
            if(u==n-1)return cost;
            if(cost>dist[u][time])continue;
            for(Pair p:g.get(u)){
                int nt=time+p.t;
                if(nt>maxTime)continue;
                int nc=cost+fee[p.v];
                if(nc<dist[p.v][nt]){
                    dist[p.v][nt]=nc;
                    pq.add(new int[]{nc,p.v,nt});
                }
            }
        }
        return -1;
    }
}
