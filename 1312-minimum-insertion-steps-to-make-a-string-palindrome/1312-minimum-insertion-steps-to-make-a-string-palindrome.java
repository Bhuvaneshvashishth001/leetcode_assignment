class Solution {
    public int insert(int i,int j ,String s,int dp[][]){
        if(i>j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] =  insert(i+1,j-1,s,dp);
        }
        else{
            int first = 1+insert(i+1,j,s,dp);
            int second = 1+insert(i,j-1,s,dp);
            return dp[i][j] = Math.min(first,second);
        }
    }
    public int minInsertions(String s) {
        int n = s.length();
        int dp[][] = new int[n+1][n+1];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        return insert(0,n-1,s,dp);
    }
}