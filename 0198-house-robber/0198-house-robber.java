class Solution {
    public int robber(int idx,int nums[],int dp[]){
        if(idx>= nums.length){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int pick = nums[idx] + robber(idx+2,nums,dp);
        int notPick = robber(idx+1,nums,dp);
        return dp[idx] = Math.max(pick,notPick);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return robber(0,nums,dp);
    }
}