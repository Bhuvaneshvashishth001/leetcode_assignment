class Solution {

    public int solve(int idx, int[] points, int[] dp) {

        if (idx <= 0) {
            return idx == 0 ? points[0] : 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        int pick = points[idx] + solve(idx - 2, points, dp);

        int notPick = solve(idx - 1, points, dp);

        return dp[idx] = Math.max(pick, notPick);
    }

    public int deleteAndEarn(int[] nums) {

        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] points = new int[max + 1];

        for (int num : nums) {
            points[num] += num;
        }

        int[] dp = new int[max + 1];

        Arrays.fill(dp, -1);

        return solve(max, points, dp);
    }
}