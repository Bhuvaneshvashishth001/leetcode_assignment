class Solution {
    public int robber(int arr[],int idx,int n,int dp[]){
        if(idx>=n){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int pick = arr[idx] + robber(arr,idx+2,n,dp);
        int notPick = robber(arr,idx+1,n,dp);
        return dp[idx]  = Math.max(pick,notPick);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int dp1[] = new int[n];
        Arrays.fill(dp1,-1);
        int case1 = robber(nums,0,n-1,dp1);
        int dp2[] = new int[n];
        Arrays.fill(dp2,-1);
        int case2 = robber(nums,1,n,dp2);
        return Math.max(case1,case2);
    }
}