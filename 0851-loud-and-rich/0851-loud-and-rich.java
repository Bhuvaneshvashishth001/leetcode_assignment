class Solution {

    public static int dfs(int node, int poor[], int millionaire[],
                          ArrayList<ArrayList<Integer>> adj,
                          int quiet[], int[] bestQuiet, int[] bestPerson) {

        if (millionaire[node] != -1) {
            return millionaire[node];
        }

        // initialize
        bestQuiet[node] = quiet[node];
        bestPerson[node] = node;

        for (int ele : adj.get(node)) {
            int rich = dfs(ele, poor, millionaire, adj, quiet, bestQuiet, bestPerson);

            if (bestQuiet[rich] < bestQuiet[node]) {
                bestQuiet[node] = bestQuiet[rich];
                bestPerson[node] = rich;
            }
        }

        millionaire[node] = bestPerson[node];
        return millionaire[node];
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;

        int millionaire[] = new int[n];
        Arrays.fill(millionaire, -1);

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        int poor[] = new int[n];
        for (int edge[] : richer) {
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u);
            poor[v]++;
        }

        int[] bestQuiet = new int[n];
        int[] bestPerson = new int[n];

        for (int i = 0; i < n; i++) {
            if (millionaire[i] == -1) {
                dfs(i, poor, millionaire, adj, quiet, bestQuiet, bestPerson);
            }
        }

        return millionaire;
    }
}
