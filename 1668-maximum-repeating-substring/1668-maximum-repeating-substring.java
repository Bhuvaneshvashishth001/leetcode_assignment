class Solution {
    public int maxRepeating(String seq, String word) {
        int n = seq.length();
        int m = word.length();
        int dp[] = new int[n+1];
        int ans = 0;
        for(int i=m;i<=n;i++){
            if(seq.substring(i-m,i).equals(word)){
                dp[i] = dp[i-m]+1;
                ans = Math.max(ans,dp[i]);
            }
        }
        return ans;
    }
}