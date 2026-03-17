class Solution {
    public int coinChange(int[] arr,int amount) {
        int n = arr.length;
        int dp[][] = new int[n][amount+1];
        int INF = (int)1e9;
        for(int i=0;i<n;i++){
            dp[i][0] =0;
        }
        for(int j=1;j<=amount;j++){
            if(j % arr[0] == 0){
                dp[0][j] = j / arr[0];
            } else {
                dp[0][j] = INF;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<=amount;j++){
                int first = dp[i-1][j];
                int second = INF;
                if(j-arr[i] > 0){
                    second = dp[i][j-arr[i]];
                }
                if(j == arr[i]){
                    second = 0;
                }
                dp[i][j]  =Math.min(first,second+1);
            }
        }
        return dp[n-1][amount] ==INF?-1:dp[n-1][amount];
    }
}