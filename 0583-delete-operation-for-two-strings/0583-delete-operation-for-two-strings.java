class Solution {
    public int minDistance(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[] dp = new int[n+1];
        for(int i=1;i<=m;i++){
        int prev = 0;
            for(int j=1;j<=n;j++){
                int t = dp[j];
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[j]=1+prev;
                }
                else{
                    dp[j]=Math.max(dp[j],dp[j-1]);
                }
            prev =t;
            }
        }
        if(dp[n]==text2.length()){
            return text1.length()-dp[n];
        }
        else{
            return text1.length()-dp[n]+text2.length()-dp[n];
        }
    }
}