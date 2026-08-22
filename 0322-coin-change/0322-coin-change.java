class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        Arrays.sort(coins);
        int dp[][] = new int[n][amount+1];
        for(int row[] : dp){
            Arrays.fill(row,amount+1);
        }
        for(int i=0;i<n;i++){
            dp[i][0] = 0;
        } 
        for(int i=0;i<n;i++){
            for(int j=1;j<=amount;j++){
                int notPick = (i>0)?dp[i-1][j]:amount+1;
                int pick = amount+1;
                if(j>=coins[i]){
                    pick = 1+dp[i][j-coins[i]];
                }
                dp[i][j] = Math.min(pick,notPick);
            }
        }
        return dp[n-1][amount] > amount ? -1:dp[n-1][amount];
    }
}