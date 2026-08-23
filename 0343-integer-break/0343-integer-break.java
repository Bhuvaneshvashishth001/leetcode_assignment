class Solution {
    public int solve(int n,int dp[]){
        if(n==1){
            return 1;
        }
        int ans = 0;
        if(dp[n] != -1){
            return dp[n];
        }
        for(int j=1;j<n;j++){
            int notBreak = j*(n-j);  
            int bre = j*solve(n-j,dp);
            ans = Math.max(ans,Math.max(bre,notBreak));
        }
        return dp[n] = ans;
    }
    public int integerBreak(int n) {
        if(n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }
}