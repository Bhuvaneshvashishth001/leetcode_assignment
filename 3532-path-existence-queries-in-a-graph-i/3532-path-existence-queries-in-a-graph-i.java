class Solution {
    class Disjoint{
        int par[];
        int rank[];
        public Disjoint(int n){
            par = new int[n];
            rank = new int[n];
            for(int i=0;i<n;i++){
                par[i] = i;
            }
        }
        public int find(int u){
            if(par[u] == u){
                return u;
            }
            return find(par[u]);
        }
        public void union(int u,int v){
            int par_u = find(u);
            int par_v = find(v);
            if(par_u == par_v){
                return;
            }
            if(rank[par_u] > rank[par_v]){
                par[par_v] = par[par_u];
            }
            else if(rank[par_u]<rank[par_v]){
                par[par_u] = par[par_v];
            }
            else{
                par[par_v] = par[par_u];
                rank[par_u]++;
            }
        }
    }
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        Disjoint ds = new Disjoint(n);
        for(int i=1;i<n;i++){
            if(Math.abs(nums[i-1]-nums[i])<=maxDiff){
                ds.union(i-1,i);
            }
        } 
        int j=0;
        boolean valid[] = new boolean[queries.length];
        for(int edge[]:queries){
            int u = edge[0];
            int v= edge[1];
            if(ds.find(u) == ds.find(v)){
                valid[j] = true;
            }
            else{
                valid[j] = false;
            }
            j++;
        }
        return valid;
    }
}