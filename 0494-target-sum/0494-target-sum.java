class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;
        int total = 0;

        for(int num : nums){
            total += num;
        }

        int sum = total + target;

        if(sum < 0 || sum % 2 != 0){
            return 0;
        }

        int amount = sum / 2;

        int dp[][] = new int[n][amount+1];

        // base case
        if(nums[0] == 0){
            dp[0][0] = 2;
        } else {
            dp[0][0] = 1;
            if(nums[0] <= amount){
                dp[0][nums[0]] = 1;
            }
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<=amount;j++){

                int first = dp[i-1][j];

                int second = 0;
                if(j - nums[i] >= 0){
                    second = dp[i-1][j - nums[i]];
                }

                dp[i][j] = first + second;
            }
        }

        return dp[n-1][amount];
    }
}