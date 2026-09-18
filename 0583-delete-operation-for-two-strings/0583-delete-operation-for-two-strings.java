class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = 1+dp[i+1][j+1];
                }
                else{
                    int first = dp[i+1][j];
                    int second = dp[i][j+1];
                    dp[i][j] = Math.max(first,second);
                }
            }
        }
        int lcs = dp[0][0];
        return (n+m)-(2*lcs);
    }
}