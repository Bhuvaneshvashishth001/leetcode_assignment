class Solution {
    int dp[][];
    public int helper(int i, int j,String s,String t){
        if(j == t.length()){
            return 1;
        } 
        if(i == s.length()){
            return 0;
        }    
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ans = 0;
        if(s.charAt(i) == t.charAt(j)){
            int pick = helper(i+1,j+1,s,t);
            int notPick = helper(i+1,j,s,t);
            ans = pick+notPick;
        }
        else{
            ans =  helper(i+1,j,s,t);
        }
        return dp[i][j] = ans;
    }
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(m>n){
            return 0;
        }
        dp = new int[n][m];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        return helper(0,0,s,t);
    }
}