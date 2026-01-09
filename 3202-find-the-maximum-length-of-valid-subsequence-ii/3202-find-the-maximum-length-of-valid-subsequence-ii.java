class Solution {
    public int maximumLength(int[] nums,int k){
        int[][] dp=new int[k][k];
        int ans=1;
        for(int x:nums){
            int m=x%k;
            for(int a=0;a<k;a++){
                dp[m][a]=dp[a][m]+1;
                ans=Math.max(ans,dp[m][a]);
            }
        }
        return ans;
    }
}
