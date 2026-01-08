class Solution {
    public boolean helper(int arr[],int idx,int target,Boolean dp[][]){
        if(target == 0){
            return true;
        }
        if(idx>= arr.length){
            return false;
        }
        if(dp[idx][target] != null){
            return dp[idx][target];
        }
        if(target-arr[idx]>=0){
            if(helper(arr,idx+1,target-arr[idx],dp)){
                return dp[idx][target] = true;
            }
        }
        return dp[idx][target] = helper(arr,idx+1,target,dp);
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += nums[i];
        }
        if(sum %2 !=0){
            return false;
        }
        int target = sum/2;
        Boolean dp[][] = new Boolean[n][target+1];
        return helper(nums,0,target,dp);
    }
}