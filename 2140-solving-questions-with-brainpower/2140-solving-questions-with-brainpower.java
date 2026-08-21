class Solution {
    public long mostPoints(int[][] que) {
        int n = que.length;
        long dp[] = new long[n];
        dp[n-1] = que[n-1][0];
        for(int i=n-2 ;i>=0 ;i--){
            long pick = que[i][0] + ((i+que[i][1]+1 < n) ? dp[i+que[i][1]+1] : 0);
            long notPick = dp[i+1];
            dp[i] = Math.max(pick,notPick);
        }
        return dp[0];
    }
}