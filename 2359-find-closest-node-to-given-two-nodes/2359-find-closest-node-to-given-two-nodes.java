class Solution {
    public static void dfs(int node,ArrayList<ArrayList<Integer>> adj,int dis[],int vis[],int d){
        vis[node]=1;
        dis[node] = Math.min(d,dis[node]);
        for(int it:adj.get(node)){
            if(vis[it]!=1){
                dfs(it,adj,dis,vis,dis[node]+1);
            }
        }
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            int v = edges[i];
            if(v!=-1){
                adj.get(i).add(v);
            }            
        }
        int vis[] = new int[n];
        int dist1[] = new int[n];
        int dist2[]  = new int[n];
        Arrays.fill(dist1,Integer.MAX_VALUE);
        dfs(node1,adj,dist1,vis,0);

        Arrays.fill(vis,0);
        Arrays.fill(dist2,Integer.MAX_VALUE);
        dfs(node2,adj,dist2,vis,0);
        int dis[] = new int[n];
        for(int i=0;i<n;i++){
            dis[i] = Math.max(dist1[i],dist2[i]);
        }
        int ans = -1;
        int best = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(dist1[i] != Integer.MAX_VALUE && dist2[i] != Integer.MAX_VALUE){
                int max = Math.max(dist1[i], dist2[i]);
                if(max < best){
                    best = max;
                    ans = i;
                }
            }
        }
        return ans;
    }
}