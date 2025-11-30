class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int indegree[] = new int[n];
        for(int edge[]:richer){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int millionaire[] = new int[n];
        for(int i=0;i<n;i++){
            millionaire[i] = i;
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int nei :adj.get(node)){
                if(quiet[millionaire[node]] < quiet[millionaire[nei]]){
                    millionaire[nei] = millionaire[node];
                }
                indegree[nei]--;
                if(indegree[nei] == 0){
                    queue.add(nei);
                }
            }
        }
        return millionaire;
    }
}