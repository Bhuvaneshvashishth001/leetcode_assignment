class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int outDegree[] = new int[n];
        for(int i=0;i<n;i++){
            for(int v:graph[i]){
                adj.get(v).add(i);
                outDegree[i]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(outDegree[i] == 0){
                ans.add(i);
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int it:adj.get(node)){
                outDegree[it]--;
                if(outDegree[it] == 0){
                    ans.add(it);
                    queue.add(it);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}