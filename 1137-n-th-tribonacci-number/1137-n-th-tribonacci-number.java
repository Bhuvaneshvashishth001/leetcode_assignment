class Solution {
    public int tribonaccii(int n ,int dp[]){
        if(n == 0 || n == 1){
            return n;
        }
        if(n==2){
            return n-1;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        return dp[n] = tribonaccii(n-1,dp)+tribonaccii(n-2,dp)+tribonaccii(n-3,dp);
    }
    public int tribonacci(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return tribonaccii(n,dp);
    }
}