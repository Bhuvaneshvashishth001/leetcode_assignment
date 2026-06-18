class Solution {
    public int robber(int nums[],int idx , int dp[]){
        if(idx >= nums.length){
            return 0;
        }
        if(dp[idx] !=-1){
            return dp[idx];
        }
        int rob = nums[idx]+robber(nums,idx+2,dp);
        int notRob = robber(nums,idx+1,dp);
        return dp[idx] = Math.max(rob,notRob);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return robber(nums,0,dp);
    }
}