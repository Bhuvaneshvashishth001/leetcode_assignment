class Solution {
    int mod =1000000007;
    public long helper(int n,Long dp[]){
        if(n==0){
            return 1;
        }
        if(n==1){
            return 2;
        }
        if(dp[n]!=null){
            return dp[n];
        }
        return dp[n] = (helper(n-1,dp)+helper(n-2,dp))%mod;
    } 
    public int countHousePlacements(int n) {
        Long dp[] = new Long[n+1];
        long one = helper(n,dp);
        return (int)((one*one)%mod);
    }
}