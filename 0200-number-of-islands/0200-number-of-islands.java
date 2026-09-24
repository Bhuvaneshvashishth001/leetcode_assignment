class Solution {
    int dr[] = {-1,0,0,1};
    int dc[] = {0,-1,1,0};
    public void dfs(int row,int col,char grid[][],int vis[][]){
        vis[row][col] = 1;
        for(int i=0;i<4;i++){
            int drow = row+dr[i];
            int dcol = col+dc[i];
            if(drow>=0 && drow<grid.length && dcol >=0 && dcol < grid[0].length && vis[drow][dcol] != 1 && grid[drow][dcol] == '1'){
                dfs(drow,dcol,grid,vis);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int visited[][] = new int[n][m];
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1' && visited[i][j] != 1){
                    count++;
                    dfs(i,j,grid,visited);
                }
            }
        }
        return count;
    }
}