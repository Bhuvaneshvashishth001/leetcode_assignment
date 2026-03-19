class Solution {
    int dp[][];
    public int helper(String s,int i,int j){
        if(i>j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = helper(s,i+1,j-1);
        }
        else{
            int first = 1+helper(s,i+1,j);
            int second = 1+helper(s,i,j-1);
            return dp[i][j] =Math.min(first,second);
        }
    }
    public int minInsertions(String s) {
        int n = s.length();
        dp = new int[n][n];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return helper(s,0,n-1);
    }
}