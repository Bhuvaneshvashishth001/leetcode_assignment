class Solution {
    public int helper(int row,int col,char matrix[][],int dp[][]){
        if(row >= matrix.length || col >= matrix[0].length){
            return 0;
        }
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        if(matrix[row][col] == '1'){
            int right = helper(row,col+1,matrix,dp); 
            int down = helper(row+1,col,matrix,dp);
            int dig = helper(row+1,col+1,matrix,dp);
            return dp[row][col] = 1+Math.min(right,Math.min(down,dig));
        }
        return dp[row][col] = 0;
    }
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n][m];
        for(int row[] :dp){
            Arrays.fill(row,-1);
        }
        int max = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] == '1'){
                    max = Math.max(max,helper(i,j,matrix,dp));
                }
            }
        }
        return max*max;
    }
}