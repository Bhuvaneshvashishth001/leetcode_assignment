class Solution {
    public int robber(int arr[],int idx,int dp[]){
        if(idx>=arr.length){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int pick = arr[idx]+robber(arr,idx+2,dp);
        int notPick = robber(arr,idx+1,dp);
        dp[idx] = Math.max(pick,notPick);
        return dp[idx];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return robber(nums,0,dp);
    }
}