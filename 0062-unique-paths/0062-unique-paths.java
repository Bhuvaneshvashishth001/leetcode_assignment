class Solution {
    int dr[] = {0,1};
    int dc[] = {1,0};
    public int path(int sr,int sc,int er,int ec,int dp[][]){
        if(sr == er && sc == ec){
            return 1;
        }
        if(dp[sr][sc] != -1){
            return dp[sr][sc];
        }
        int count = 0;
        for(int i =0;i<2;i++){
            int drow = sr+dr[i];
            int dcol = sc+dc[i];
            if(drow >=0 && drow <= er && dcol >=0 && dcol<=ec){
                count += path(drow,dcol,er,ec,dp);
            }
        }
        return dp[sr][sc] = count;
    }
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[n][m];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        return path(0,0,n-1,m-1,dp);
    }
}