class Solution {
    class Tuple{
        int src;
        int spend;
        public Tuple(int src,int spend){
            this.src = src;
            this.spend = spend;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[] : times){
            int u = edge[0]-1;
            int v = edge[1]-1;
            int w = edge[2];
            adj.get(u).add(new int[]{v,w});
        }
        int spent[] = new int[n];
        Arrays.fill(spent, Integer.MAX_VALUE);
        PriorityQueue<Tuple> queue = new PriorityQueue<>((a,b)->a.spend-b.spend);
        spent[k-1] = 0;
        queue.add(new Tuple(k-1,0));
        while(!queue.isEmpty()){
            Tuple t = queue.poll();
            int src = t.src;
            int spend = t.spend;
            for(int edge[] : adj.get(src)){
                if(spent[edge[0]] > spend+edge[1]){
                    spent[edge[0]] = spend+edge[1];
                    queue.add(new Tuple(edge[0],spent[edge[0]]));
                }
            }
        }
        int max = 0;
        for(int i=0;i<n;i++){
            if(spent[i] == Integer.MAX_VALUE){
                return -1;
            }
            max = Math.max(max,spent[i]);
        }
        return max;
    }
}