class Solution {
    public void dfs(int row,int col,char grid[][],int islands[][]){
        islands[row][col] = 1;
        int dr[] = {-1,0,0,1};
        int dc[] = {0,-1,1,0};
        for(int i=0;i<4;i++){
            int drow = row+dr[i];
            int dcol = col+dc[i];
            if(drow >= 0 && drow <grid.length && dcol >= 0 && dcol <grid[0].length && grid[drow][dcol] == '1' && islands[drow][dcol] == 0){
                dfs(drow,dcol,grid,islands);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        int islands[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1' && islands[i][j] == 0){
                    count++;
                    dfs(i,j,grid,islands);
                }
            }
        }
        return count;
    }
}