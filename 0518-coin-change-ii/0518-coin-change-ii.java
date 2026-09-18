class Solution {
    public int ways(int idx,int length,int amount,int coins[],int dp[][]){
        if(amount == 0){
            return 1;
        }
        if(amount<0){
            return 0;
        }
        if(idx >= length){
            return 0;
        }
        if(dp[idx][amount] != -1){
            return dp[idx][amount];
        }
        int count  = 0;
        if(coins[idx] <= amount){
            count += ways(idx,length,amount-coins[idx],coins,dp);
        }
        count += ways(idx+1,length,amount,coins,dp);
        return dp[idx][amount] = count;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n+1][amount+1];
        for(int row[] :dp){
            Arrays.fill(row,-1);
        }
        return ways(0,n,amount,coins,dp);
    }
}