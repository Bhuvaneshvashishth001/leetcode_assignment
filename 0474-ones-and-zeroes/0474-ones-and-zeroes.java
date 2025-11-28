class Solution {
    static int[][][] dp;
    public static int helper(String str[], int m, int n, int idx) {
        if (idx == str.length) return 0;
        if (dp[idx][m][n] != -1) return dp[idx][m][n];
        int count_0 = 0, count_1 = 0;
        for (char c : str[idx].toCharArray()) {
            if (c == '0') count_0++;
            else count_1++;
        }
        int notTake = helper(str, m, n, idx + 1);
        int take = 0;
        if (count_0 <= m && count_1 <= n){ 
            take = 1 + helper(str, m - count_0, n - count_1, idx + 1);
        }
        return dp[idx][m][n] = Math.max(take, notTake);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        dp = new int[strs.length][m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) dp[i][j][k] = -1;
            }
        }
        return helper(strs, m, n, 0);
    }
}
