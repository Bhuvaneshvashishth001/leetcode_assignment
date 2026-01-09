class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int i=0;i<n;i++){
            dp[i][0] =1;
        }
        for(int j=1;j<=amount ;j++){
            if(j-coins[0] >=0){
                dp[0][j] = dp[0][j-coins[0]];
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<=amount ;j++){
                int pick = j-coins[i];
                if(pick>=0){
                    dp[i][j] = dp[i][pick]+dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n-1][amount];
    }
}