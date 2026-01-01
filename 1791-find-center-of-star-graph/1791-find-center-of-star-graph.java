class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length+1;
        int indegree[] = new int[n];
        for(int edge[]:edges){
            int u = edge[0]-1;
            int v = edge[1]-1;
            indegree[u]++;
            indegree[v]++;
        }
        for(int i=0;i<n;i++){
            if(indegree[i] == n-1){
                return i+1;
            }
        }
        return -1;
    }
}