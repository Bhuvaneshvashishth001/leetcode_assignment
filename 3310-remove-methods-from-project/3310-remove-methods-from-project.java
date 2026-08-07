class Solution {
    public boolean dfs2(int src,List<List<Integer>> adj ,int mark[],int vis[]){
        vis[src]=1;
        for(int it:adj.get(src)){
            if(mark[it] == 1){
                return true;
            }
            if(vis[it]!=1 && dfs2(it,adj,mark,vis)){
                return true;
            }
        }
        return false;
    }
    public void dfs(int src,List<List<Integer>> adj,int mark[],int vis[]){
        vis[src] =1;
        for(int it:adj.get(src)){
            if(mark[it] != 1 && vis[it] != 1){
                mark[it] =1;
                dfs(it,adj,mark,vis);
            }
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] edges) {
       List<List<Integer>>adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[]:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        int vis[] = new int[n];
        boolean flag = false;
        int mark[] = new int[n];
        mark[k] =1;
        dfs(k,adj,mark,vis);
        for(int i=0;i<n;i++){
            if(mark[i] != 1){
                if(dfs2(i,adj,mark,vis)){
                    flag = true;
                    break;
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        if(flag){
            for(int i = 0;i<n;i++){
                ans.add(i);
            }
        }
        else{
            for(int i=0;i<n;i++){
                if(mark[i] != 1){
                    ans.add(i);
                }
            }
        }
        return ans;
    }
}