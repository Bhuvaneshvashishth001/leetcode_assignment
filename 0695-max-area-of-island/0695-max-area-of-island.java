class Solution {
    int dc[] = {-1,0,0,1};
    int dr[] = {0,-1,1,0};
    public int dfs(int row,int col,int grid[][],int vis[][]){
        vis[row][col] =1;
        int count = 0;
        for(int i=0;i<4;i++){
            int drow = row+dr[i];
            int dcol = col+dc[i];
            if(drow >= 0 && drow<grid.length && dcol >= 0 && dcol < grid[0].length && grid[drow][dcol] == 1 && vis[drow][dcol] != 1){
                count += (1+dfs(drow,dcol,grid,vis));
            }
        }
        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        int max = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1 && vis[i][j] != 1){
                    max = Math.max(max,1+dfs(i,j,grid,vis));
                }
            }
        }
        return max;
    }
}