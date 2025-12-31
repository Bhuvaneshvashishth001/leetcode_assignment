class Disjoint{
    int rank[];
    int par[];
    public Disjoint(int n){
        rank = new int[n];
        par = new int[n];
        for(int i=0;i<n;i++){
            par[i] = i;
        }
    }
    public int find(int u){
        if(par[u] == u){
            return u;
        }
        return par[u] = find(par[u]);
    }
    public void union(int u,int v){
        int par_u = find(u);
        int par_v = find(v);
        if(par_u == par_v){
            return;
        }
        if(rank[par_u] >rank[par_v]){
            par[par_v] = par_u;
        }
        else if(rank[par_v] >rank[par_u]){
            par[par_u] = par_v;
        }
        else{
            par[par_v] = par_u;
            rank[par_u]++;
        }
    }
}
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Disjoint ds = new Disjoint(n);
        for(int edge[]:edges){
            int u = edge[0];
            int v = edge[1];
            ds.union(u,v); 
        }
        return ds.find(source) == ds.find(destination);
    }
}