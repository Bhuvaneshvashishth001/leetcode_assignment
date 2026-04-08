class Solution {
    Integer dp[][];
    public int helper(int idx, int arr[], int sum) {
        if (idx == arr.length) {
            if(sum == 0){
                return 0;
            } 
            return Integer.MIN_VALUE;
        }
        if(dp[idx][sum] != null){
            return dp[idx][sum];
        }
        int next = helper(idx + 1, arr, (sum + arr[idx]) % 3);
        int pick = (next == Integer.MIN_VALUE) ? Integer.MIN_VALUE : arr[idx] + next;
        int notPick = helper(idx + 1, arr, sum);
        return dp[idx][sum] = Math.max(pick, notPick);
    }
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        dp = new Integer[n][3];
        return helper(0, nums, 0);
    }
}