class Solution {
    int dp[][];
    public int helper(int sr,int sc,int er,int ec,int grid[][]){
        if(sr == er && sc == ec){
            return 1;
        }
        if(dp[sr][sc] !=-1){
            return dp[sr][sc];
        }
        int dr[] = {1,0};
        int dc[] = {0,1};
        int ans = 0;
        for(int i=0;i<2;i++){
            int drow = sr+dr[i];
            int dcol = sc+dc[i];
            int first = 0;
            int second = 0;
            if(i==0 && drow>=0 && drow<grid.length && dcol>=0 && dcol<grid[0].length && grid[drow][dcol] == 0){
                first = helper(drow,dcol,er,ec,grid);
            }
            if(i==1 && drow>=0 && drow<grid.length && dcol>=0 && dcol<grid[0].length && grid[drow][dcol] == 0){
                second = helper(drow,dcol,er,ec,grid);
            }
            ans += first+second;
        }
        return dp[sr][sc] = ans;
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1){
            return 0;
        }
        dp = new int[n][m];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return helper(0,0,n-1,m-1,grid);
    }
}