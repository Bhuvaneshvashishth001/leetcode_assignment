class Solution {
    long dp[][];
    public long helper(int idx,int arr[],int turn){
        if(idx>=arr.length){
            return 0;
        }
        if(dp[idx][turn] != -1){
            return dp[idx][turn];
        }
        long pick = 0;
        long notPick = 0;
        if(turn == 0){
            pick = (pick+arr[idx]) + helper(idx+1,arr,1);
        }
        if(turn == 1){
            pick = (pick-arr[idx]) + helper(idx+1,arr,0);
        }
        notPick = helper(idx+1,arr,turn);
        return dp[idx][turn] = Math.max(pick,notPick);
    }
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        dp = new long[n][2];
        for(long rows[]:dp){
            Arrays.fill(rows,-1);
        }
        return helper(0,nums,0);
    }
}