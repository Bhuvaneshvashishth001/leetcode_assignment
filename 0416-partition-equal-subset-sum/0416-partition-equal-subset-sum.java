class Solution {
    public static boolean subset(int idx,int arr[],int sum,Boolean dp[][]){
        if(idx <= arr.length && sum == 0){
            return true;
        }
        if(idx >= arr.length){
            return false;
        }
        if(dp[idx][sum] != null){
            return dp[idx][sum];
        }
        if(arr[idx] <= sum){
            if(subset(idx+1,arr,sum-arr[idx],dp)){
                return dp[idx][sum] = true;
            }
        }
        return dp[idx][sum] = subset(idx+1,arr,sum,dp);
    }
    public boolean canPartition(int[] nums) {
        int total = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            total += nums[i];
        }
        if(total%2 != 0){
            return false;
        }
        int sum = total/2;
        Boolean dp[][] = new Boolean[n][sum+1];
        return subset(0,nums,sum,dp);
    }
}