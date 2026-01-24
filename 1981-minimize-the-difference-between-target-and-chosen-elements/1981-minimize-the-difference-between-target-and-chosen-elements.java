class Solution {
    public int helper(int mat[][],int row,int target,int con,int dp[][]){
        if(row == mat.length){
            return Math.abs(target-con);
        }
        if(dp[row][con]!=-1){
            return dp[row][con];
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<mat[0].length;i++){
            min = Math.min(min,helper(mat,row+1,target,con+mat[row][i],dp));
        }
        return dp[row][con] = min;
    }
    public int minimizeTheDifference(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;
        int dp[][] = new int[n][4901];
        for(int edge[]:dp){
            Arrays.fill(edge,-1);
        }
        return helper(mat,0,target,0,dp);
    }
}