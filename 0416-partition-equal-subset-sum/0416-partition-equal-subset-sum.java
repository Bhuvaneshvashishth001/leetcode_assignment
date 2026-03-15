class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int num:nums){
            total += num;
        }
        if(total%2 != 0){
            return false;
        }
        int sum = total/2;
        boolean dp[][] = new boolean[n][sum+1];
        for(int i=0;i<n;i++){
            dp[i][0] = true;
        }
        if(nums[0]<= sum){
            dp[0][nums[0]] = true;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<=sum;j++){
                boolean status = false;
                if(j-nums[i] >= 0){
                    status = dp[i-1][j-nums[i]];
                }
                dp[i][j] = dp[i-1][j] || status;
            }
        }
        return dp[n-1][sum];
    }
}