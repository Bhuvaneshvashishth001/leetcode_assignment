class Solution {
    public void dfs(int node ,int [][] isConnected,boolean vis[]){
        int m  = isConnected[0].length;
        vis[node] = true;
        for(int i=0;i<m;i++){
            if(isConnected[node][i] == 1 && !vis[i]){
                dfs(i,isConnected,vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean vis[] = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,isConnected,vis);
                count++;
            }
        }
        return count;
    }
}