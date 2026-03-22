class Solution {
    int dp[][];
    public int helper(int idx,int arr[],int prevIdx){
        if(idx>=arr.length){
            return 0;
        }
        if(dp[idx][prevIdx+1] != -1){
            return dp[idx][prevIdx+1];
        }
        int pick = 0;
        int notPick = 0;
        if(prevIdx == -1 || arr[idx]>arr[prevIdx]){
            pick = 1+helper(idx+1,arr,idx);
        }
        notPick = helper(idx+1,arr,prevIdx);
        return dp[idx][prevIdx+1] = Math.max(pick,notPick);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n][n+1];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        return helper(0,nums,-1);
    }
}