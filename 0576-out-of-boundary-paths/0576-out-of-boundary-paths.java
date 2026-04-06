class Solution {
    int dp[][][];
    int mod = 1000000007;
    int dr[] = {-1,0,0,1};
    int dc[] = {0,-1,1,0};
    public int path(int sr,int sc,int move,int m,int n){
        if(move>=0 && (sr>=m || sc>=n || sr<0 || sc<0)){
            return 1;
        }
        if(move<=0){
            return 0;
        }
        if(dp[sr][sc][move] != -1){
            return dp[sr][sc][move];
        }
        int ans= 0;
        for(int i=0;i<4;i++){
            int drow = sr+dr[i];
            int dcol = sc+dc[i];
            ans = (ans+path(drow,dcol,move-1,m,n))%mod;
        }
        return dp[sr][sc][move] = ans;
    }
    public int findPaths(int m, int n, int move, int sr, int sc) {
        dp = new int[m][n][move+1];
        for(int rows[][]:dp){
            for(int row[]:rows){
                Arrays.fill(row,-1);
            }
        }
        return path(sr,sc,move,m,n);
    }
}