class Solution {
    public int helper(int nums[],int i,int j,int diff,int dp[][]){
        if(i>=j){
            return 0;
        }
        int ans = 0;
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(nums[i]+nums[i+1] == diff){
            ans = Math.max(ans,1+helper(nums,i+2,j,diff,dp));
        }
        if(nums[i]+nums[j] == diff){
            ans = Math.max(ans,1+helper(nums,i+1,j-1,diff,dp));
        }
        if(nums[j]+nums[j-1] == diff){
            ans = Math.max(ans,1+helper(nums,i,j-2,diff,dp));
        }
        return dp[i][j]=ans;
    }
    public int maxOperations(int[] nums) {
        int n = nums.length;
        int count = 0;
        int dp1[][] = new int[n][n];
        for(int row[]:dp1){
            Arrays.fill(row,-1);
        }
        count = Math.max(count,1+helper(nums,2,n-1,nums[0]+nums[1],dp1));

        int dp2[][] = new int[n][n];
        for(int row[]:dp2){
            Arrays.fill(row,-1);
        }
        count = Math.max(count,1+helper(nums,1,n-2,nums[0]+nums[n-1],dp2));

        int dp3[][] = new int[n][n];
        for(int row[]:dp3){
            Arrays.fill(row,-1);
        }
        count = Math.max(count,1+helper(nums,0,n-3,nums[n-1]+nums[n-2],dp3));
        return count;
    }
}