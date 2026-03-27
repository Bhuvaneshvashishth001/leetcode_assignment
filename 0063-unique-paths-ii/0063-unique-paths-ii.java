class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0]==1 || grid[n-1][m-1] == 1){
            return 0;
        }
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][m] = 0;
        }
        for(int i=0;i<=m;i++){
            dp[n][i] = 0;
        }
        dp[n-1][m-1] = 1;
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i == n-1 && j == m-1){
                    continue;
                }
                else{ 
                    if(grid[i][j] == 1){
                        dp[i][j] = 0;
                    }
                    else{
                        dp[i][j] = dp[i][j+1]+dp[i+1][j];
                    }
                }
            }
        }
        return dp[0][0];
    }
}