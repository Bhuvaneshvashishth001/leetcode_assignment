class Solution {
    int dr[] = {-1,0,0,1};
    int dc[] = {0,-1,1,0};
    public void dfs(int row,int col,int image[][],int grid[][],int org,int prev){
        grid[row][col] = org;
        for(int i=0;i<4;i++){
            int drow = row + dr[i];
            int dcol = col + dc[i];
            if(drow >= 0 && drow<image.length && dcol >=0&& dcol<image[0].length && image[drow][dcol] == prev && grid[drow][dcol] != org){
                grid[drow][dcol] = org;
                dfs(drow,dcol,image,grid,org,prev);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int grid[][] = new int[n][m];
        grid = image;
        dfs(sr,sc,image,grid,color,image[sr][sc]);
        return grid;
    }
}