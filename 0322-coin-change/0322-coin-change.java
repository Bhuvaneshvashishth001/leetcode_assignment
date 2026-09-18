class Solution {
    public int change(int len,int coins[],int amount,int dp[][]){
        if(amount == 0){
            return 0;
        }
        if(dp[len][amount] != -1){
            return dp[len][amount];
        }
        int minC = 1000000;
        for(int i=0;i<len;i++){
            if(coins[i] <=amount){
                int pick = 1+change(len,coins,amount-coins[i],dp);
                minC =  Math.min(minC,pick);
            }
        }
        return dp[len][amount] = minC;
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n+1][amount+1];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        return change(n,coins,amount,dp)== 1000000 ? -1 : change(n,coins,amount,dp);
    }
}