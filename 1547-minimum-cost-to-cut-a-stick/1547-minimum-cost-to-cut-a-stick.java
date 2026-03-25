class Solution {
    static int dp[][];
    public static int helper(int i,int j,int arr[],int left,int right){
        if(i>j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int s = (right-left)+helper(i,k-1,arr,left,arr[k])+helper(k+1,j,arr,arr[k],right);
            ans = Math.min(ans,s);
        }
        return dp[i][j] = ans;
    }
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        dp = new int[m][m];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        Arrays.sort(cuts);
        return helper(0,m-1,cuts,0,n);
    }
}