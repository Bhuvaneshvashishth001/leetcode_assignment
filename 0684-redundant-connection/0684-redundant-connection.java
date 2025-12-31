class Solution {
    class Disjoint {
        int par[];
        int size[];

        public Disjoint(int n) {
            par = new int[n + 1];
            size = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                par[i] = i;
                size[i] = 1;
            }
        }

        public int find(int u) {
            if (par[u] == u) {
                return u;
            }
            return find(par[u]);
        }

        public void union(int u, int v) {
            int par_u = find(u);
            int par_v = find(v);
            if (size[par_u] > size[par_v]) {
                par[par_v] = par_u;
                size[par_u] += size[par_v];
            } else if (size[par_u] > size[par_v]) {
                par[par_u] = par_v;
                size[par_v] += size[par_u];
            } else {
                par[par_v] = par_u;
                size[par_u] += size[par_v];
            }
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        Disjoint ds = new Disjoint(n);
        int ans[] = new int[2];
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            if (ds.find(u) == ds.find(v)) {
                ans[0] = u;
                ans[1] = v;
            }
            ds.union(u, v);
        }
        return ans;
    }
}