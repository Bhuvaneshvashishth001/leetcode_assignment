class Solution {
    int[][] dp;
    int offset;
    public int helper(int[] rods, int idx, int diff) {
        if (idx == rods.length) {
            if (diff == 0) return 0;
            return Integer.MIN_VALUE;
        }
        if (dp[idx][diff + offset] != Integer.MIN_VALUE) {
            return dp[idx][diff + offset];
        }
        int notPick = helper(rods, idx + 1, diff);
        int pickLeft = rods[idx] + helper(rods, idx + 1, diff + rods[idx]);
        int pickRight = helper(rods, idx + 1, diff - rods[idx]);
        return dp[idx][diff + offset] =
            Math.max(notPick, Math.max(pickLeft, pickRight));
    }

    public int tallestBillboard(int[] rods) {
        int sum = 0;
        for (int r : rods) sum += r;
        offset = sum;
        dp = new int[rods.length][2 * sum + 1];
        for (int[] row : dp)
            Arrays.fill(row, Integer.MIN_VALUE);
        return helper(rods, 0, 0);
    }
}