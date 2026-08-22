class Solution {
    public int ways(int idx,int coins[],int amount,int dp[][]){
        if(amount<0){
            return 0;
        }
        if(amount == 0){
            return 1;
        }
        if(idx >= coins.length){
            return 0;
        }
        if(dp[idx][amount] != -1){
            return dp[idx][amount];
        }
        int count = 0;
        if(amount-coins[idx] >= 0){
            count += ways(idx,coins,amount-coins[idx],dp);
        }
        count += ways(idx+1,coins,amount,dp);
        return dp[idx][amount] = count;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] =new int[n][amount+1];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        return ways(0,coins,amount,dp);
    }
}