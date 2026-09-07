class Solution {

    public int distinctSubseqII(String s) {

        int MOD = 1_000_000_007;
        long[] dp = new long[26];
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            long total = 0;
            for (int j = 0; j < 26; j++) {
                total = (total + dp[j]) % MOD;
            }
            total = (total + 1) % MOD;
            dp[ch] = total;
        }
        long ans = 0;
        for (int i = 0; i < 26; i++) {
            ans = (ans + dp[i]) % MOD;
        }
        return (int) ans;
    }
}