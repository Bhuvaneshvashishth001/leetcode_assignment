class Solution {

    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int mark[]) {

        for (int it : adj.get(node)) {

            if (mark[node] == mark[it]) {
                return false;
            }

            if (mark[it] == 0) {

                if (mark[node] == 1)
                    mark[it] = 2;
                else
                    mark[it] = 1;

                if (!dfs(it, adj, mark))
                    return false;
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            for (int num : graph[i]) {
                adj.get(i).add(num);
            }
        }

        int mark[] = new int[n];

        for (int i = 0; i < n; i++) {

            if (mark[i] == 0) {

                mark[i] = 1;

                if (!dfs(i, adj, mark))
                    return false;
            }
        }

        return true;
    }
}