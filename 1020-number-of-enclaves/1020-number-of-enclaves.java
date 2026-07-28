class Solution {
    public static void dfs(int row,int col,int grid[][],int vis[][]){
        vis[row][col] =2;
        int dr[] = {-1,0,0,1};
        int dc[] = {0,-1,1,0};
        for(int i=0;i<4;i++){
            int drow = row+dr[i];
            int dcol = col+dc[i];
            if(drow>=0 && drow<grid.length && dcol>=0 && dcol<grid[0].length && grid[drow][dcol] == 1 && vis[drow][dcol] == 0){
                dfs(drow,dcol,grid,vis);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int visited[][] = new int[n][m];
        for(int i=0;i<n;i++){
            if(grid[i][0] == 1){
                dfs(i,0,grid,visited);
            }
            if(grid[i][m-1] == 1){
                dfs(i,m-1,grid,visited);
            }
        }
        for(int i=0;i<m;i++){
            if(grid[0][i] == 1){
                dfs(0,i,grid,visited);
            }
            if(grid[n-1][i] == 1){
                dfs(n-1,i,grid,visited);
            }
        }
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    count++;
                }
            }
        }
        return count;
    }
}