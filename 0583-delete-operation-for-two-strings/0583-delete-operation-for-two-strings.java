class Solution {
    int dp[][];
    public int helper(int i,int j,String s1,String s2){
        if(i == s1.length() && j < s2.length()){
            return s2.length()-j;
        }
        if(i<s1.length() && j==s2.length()){
            return s1.length()-i;
        }
        if(i == s1.length() && j == s2.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = helper(i+1,j+1,s1,s2);
        }
        else{
            int first = 1+helper(i+1,j,s1,s2);
            int second = 1+helper(i,j+1,s1,s2);
            return dp[i][j] = Math.min(first,second);
        }
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        dp = new int[n+1][m+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return helper(0,0,word1,word2);
    }
}