class Solution {
    public int com(int idx,int coins[],int amount, int org,int dp[][]){
        if(amount<0){
            return org+1;
        }
        if(amount == 0){
            return 0;
        }
        if(idx >= coins.length){
            return org+1;
        }
        if(dp[idx][amount] != Integer.MAX_VALUE){
            return dp[idx][amount];
        }
        int pick = 1+com(idx,coins,amount-coins[idx],org,dp);
        int notPick = com(idx+1,coins,amount,org,dp);
        return dp[idx][amount] = Math.min(pick,notPick);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int row[] : dp){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        return (com(0,coins,amount,amount,dp)>amount)? -1 : com(0,coins,amount,amount,dp);
    }
}