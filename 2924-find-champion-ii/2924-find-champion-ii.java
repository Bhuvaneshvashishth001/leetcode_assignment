class Solution {
    public int findChampion(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int indegree[] = new int[n];
        for(int edge[]:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            indegree[v]++;
        }
        int count =0;
        int ans =-1;
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                count++;
                ans = i;
            }
        }
        if(count >1){
            return -1;
        }
        return ans;
    }
}