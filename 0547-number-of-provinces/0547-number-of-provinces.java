class Solution {
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
        public int find(int node){
            if(par[node] == node){
                return node;
            }
            return par[node] = find(par[node]);
        }
        public void union(int u,int v){
            int par_u = find(u);
            int par_v = find(v);
            if(par_u == par_v){
                return;
            }
            if(rank[par_v]>rank[par_u]){
                par[par_u] = par_v;
            }
            else if(rank[par_u]>rank[par_v]){
                par[par_v] = par_u; 
            }
            else{
                par[par_v] = par_u;
                rank[par_u]++;
            }
        }
    }
    public int findCircleNum(int[][] conn) {
        int n = conn.length;
        int m = conn[0].length;
        Disjoint ds = new Disjoint(n);
        int count = 0;
        int visit[] = new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(conn[i][j] ==1){
                    ds.union(i,j);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(ds.find(i) ==i){
                count++;
            }
        }
        return count;
    }
}