class Solution {
    public long points(int idx,int que[][],long dp[]){
        if(idx >= que.length){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        long pick = que[idx][0]+points(idx+que[idx][1]+1,que,dp);
        long notPick = points(idx+1,que,dp);
        return dp[idx] = Math.max(pick,notPick);
    }
    public long mostPoints(int[][] que) {
        int n = que.length;
        long dp[] = new long[n];
        Arrays.fill(dp,-1);
        return points(0,que,dp);
    }
}