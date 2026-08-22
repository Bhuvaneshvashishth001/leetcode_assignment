class Solution {
    public int comb(int idx,int nums[],int target,int dp[][]){
        if(target < 0){
            return 0;
        }
        if(idx >= nums.length){
            return 0;
        }
        if(target == 0){
            return 1;
        }
        if(dp[idx][target] != -1){
            return dp[idx][target];
        }
        int count = 0;
        for(int i=0;i<nums.length;i++){
            count += comb(i,nums,target-nums[i],dp);
        }
        return dp[idx][target] = count;
    }
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int dp[][] = new int[n][target+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return comb(0,nums,target,dp);
    }
}