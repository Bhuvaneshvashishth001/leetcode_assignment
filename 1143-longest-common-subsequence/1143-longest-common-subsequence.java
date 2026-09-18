class Solution {
    public int common(String text1,String text2,int dp[][]){
        if(text1.length()<=0  || text2.length() <= 0){
            return 0;
        }
        if(dp[text1.length()][text2.length()] != -1){
            return dp[text1.length()][text2.length()];
        }
        if(text1.charAt(0) == text2.charAt(0)){
            return dp[text1.length()][text2.length()] = 1+common(text1.substring(1),text2.substring(1),dp);
        }
        else{
            int first = common(text1.substring(1),text2,dp);
            int second = common(text1,text2.substring(1),dp);
            return dp[text1.length()][text2.length()] = Math.max(first,second);
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n+1][m+1];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        return common(text1,text2,dp);
    }
}