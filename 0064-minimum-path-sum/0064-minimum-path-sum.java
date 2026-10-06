class Solution {
    int dr[] = {1,0};
    int dc[] = {0,1};
    public int findSum(int sr,int sc,int er,int ec,int grid[][],int dp[][]){
        if(sr == er && sc == ec){
            return grid[er][ec];
        }
        if(dp[sr][sc] != Integer.MAX_VALUE){
            return dp[sr][sc];
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<2;i++){
            int drow = sr+dr[i];
            int dcol = sc+dc[i];
            if(drow >=0 && drow<=er && dcol>=0 && dcol<=ec){
                min = Math.min(min,grid[sr][sc]+findSum(drow,dcol,er,ec,grid,dp));
            }
        }
        dp[sr][sc] = min;
        return dp[sr][sc];
    }
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n][m];
        for(int row[] : dp){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        return findSum(0,0,n-1,m-1,grid,dp);
    }
}