class Solution {
    public int robbery(int idx,int nums[],int dp[]){
        if(idx >= nums.length){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int pick = nums[idx] + robbery(idx+2,nums,dp);
        int notPick = robbery(idx+1,nums,dp);
        return dp[idx] = Math.max(pick,notPick);
    }
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        return robbery(0,nums,dp);
    }
}