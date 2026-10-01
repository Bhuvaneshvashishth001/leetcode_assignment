class Solution {

    public static void dfs(int i, ArrayList<ArrayList<Integer>> adj, int[] vis) {
        vis[i] = 1;

        for (int node : adj.get(i)) {
            if (vis[node] != 1) {
                dfs(node, adj, vis);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }

        int[] vis = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                count++;
                dfs(i, adj, vis);
            }
        }

        return count;
    }
}