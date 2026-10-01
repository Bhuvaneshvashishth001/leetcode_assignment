class Solution {
    public void dfs(int node,int[][] isConnected,int vis[]){
        vis[node] =1;
        for(int i=0;i<isConnected[0].length;i++){
            if(isConnected[node][i] == 1 && vis[i]!= 1){
                dfs(i,isConnected,vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int m = isConnected[0].length;
        int vis[] = new int[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(vis[i] != 1){
                count++;
                dfs(i,isConnected,vis);
            }
        }
        return count;
    }
}