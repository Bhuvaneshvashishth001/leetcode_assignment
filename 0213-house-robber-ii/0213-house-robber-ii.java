class Solution {
    public int robbery(int idx,int e,int nums[],int dp[]){
        if(idx >= e){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int pick = nums[idx]+robbery(idx+2,e,nums,dp);
        int notPick = robbery(idx+1,e,nums,dp);
        return dp[idx] =  Math.max(pick,notPick);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0],nums[1]);
        }
        int dp1[] = new int[n];
        Arrays.fill(dp1,-1);
        int case1 = robbery(0,n-1,nums,dp1);
        int dp2[] = new int[n];
        Arrays.fill(dp2,-1);
        int case2 = robbery(1,n,nums,dp2);
        return Math.max(case1,case2);
    }
}