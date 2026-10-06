class Solution {
    int dr[] = {1,0};
    int dc[] = {0,1};
    public int path(int sr,int sc,int er,int ec,int grid[][],int dp[][]){
        if(sr == er && sc == ec){
            return 1;
        }
        if(dp[sr][sc]  != -1){
            return dp[sr][sc];
        }
        int count = 0;
        for(int i=0;i<2;i++){
            int drow = sr+dr[i];
            int dcol = sc+dc[i];
            if(drow >= 0 && drow <= er && dcol >= 0 && dcol <= ec && grid[drow][dcol] == 0){
                count += path(drow,dcol,er,ec,grid,dp);
            }
        }
        dp[sr][sc] = count;
        return dp[sr][sc];
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n][m];
        for(int rows[] : dp){
            Arrays.fill(rows,-1);
        }   
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1){
            return 0;
        }
        return path(0,0,n-1,m-1,grid,dp);
    }
}