class Solution {
    public int longestPalindromeSubseq(String s1) {
        int n = s1.length();
        StringBuilder sb = new StringBuilder(s1);
        int dp[][] = new int[n][n];
        for(int rows[] :dp){
            Arrays.fill(rows,-1);
        }
        sb.reverse();
        String s2 = sb.toString();
        return palindrome(s1,s2,0,0,dp);
    }
    public int palindrome(String s1,String s2,int idx1,int idx2,int dp[][]){
        if(idx1 >= s1.length() || idx2>=s2.length()){
            return 0;
        }
        if(dp[idx1][idx2] != -1){
            return dp[idx1][idx2];
        }
        if(s1.charAt(idx1) == s2.charAt(idx2)){
            return dp[idx1][idx2] = 1+palindrome(s1,s2,idx1+1,idx2+1,dp);
        }
        else{
            int first = palindrome(s1,s2,idx1+1,idx2,dp);
            int second = palindrome(s1,s2,idx1,idx2+1,dp);
            return dp[idx1][idx2] = Math.max(first,second);
        }
    }
}