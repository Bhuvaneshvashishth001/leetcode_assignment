class Solution {
    class Pair{
        int des;
        int price;
        int stop;
        public Pair(int des,int price,int stop){
            this.des = des;
            this.price = price;
            this.stop = stop;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int flight[] :flights){
            int u = flight[0];
            int v = flight[1];
            int w = flight[2];
            adj.get(u).add(new Pair(v,w,0));
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b)->a.price-b.price);
        int dist[][] = new int[n][k+2];
        for(int arr[]:dist){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        dist[src][0] = 0;
        queue.add(new Pair(src,0,0));
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int des = p.des;
            int spend = p.price;
            int stop = p.stop;
            if(des == dst){
                return spend;
            }
            if(stop<=k){
                for(Pair it:adj.get(des)){
                    int total = spend+it.price;
                    if(total<dist[it.des][stop+1]){
                        dist[it.des][stop+1] = total;
                        queue.add(new Pair(it.des,total,stop+1));
                    }
                }
            }
        }
        return -1;
    }
}