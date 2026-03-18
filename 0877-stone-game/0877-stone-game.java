class Solution {
    public int helper(int arr[],int i,int j,int dp[][]){
        if(i>j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int first = arr[i] - helper(arr,i+1,j,dp);
        int second = arr[j] - helper(arr,i,j-1,dp);
        return dp[i][j] = Math.max(first,second);
    }
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int dp[][] = new int[n][n];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return helper(piles,0,n-1,dp)>0;
    }
}