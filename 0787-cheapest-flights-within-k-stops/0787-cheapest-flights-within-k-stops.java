class Solution {
    class Tuple{
        int src;
        int spend;
        int stop;
        public Tuple(int src,int spend,int stop){
            this.src = src;
            this.spend = spend;
            this.stop = stop;
        }
    }
    class Pair{
        int node;
        int price;
        public Pair(int node,int price){
            this.node = node;
            this.price = price;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[] : flights){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new Pair(v,w));
        }
        int dist[][] = new int[n][k+2];
        for(int row[]:dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        PriorityQueue<Tuple> queue = new PriorityQueue<>((a,b)->a.spend - b.spend);
        queue.add(new Tuple(src,0,0));
        dist[src][0] = 0;
        while(!queue.isEmpty()){
            Tuple t = queue.poll();
            int node = t.src;
            int price = t.spend;
            int stops = t.stop;
            if(node == dst){
                return price;
            }
            if(stops<=k){
                for(Pair p : adj.get(node)){
                    if(dist[p.node][stops+1] > price+p.price){
                        dist[p.node][stops+1] = price+p.price;
                        queue.add(new Tuple(p.node,price+p.price,stops+1));
                    }
                }
            }
        }
        return -1;
    }
}