class Solution {
    public static int helper(int row,int col,char mat[][],int n,int m,int dp[][]){
        if(row>=n || col>=m){
            return 0;
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        if(mat[row][col] == '1'){
            int down = helper(row+1,col,mat,n,m,dp);
            int right = helper(row,col+1,mat,n,m,dp);
            int dig = helper(row+1,col+1,mat,n,m,dp);
            return dp[row][col] = 1 + Math.min(down, Math.min(right, dig));
        }
        else{
            return dp[row][col] = 0;
        }
    }
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n][m];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] =='0'){
                    dp[i][j] = 0;
                }
                else{
                    helper(i,j,matrix,n,m,dp);
                }
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans = Math.max(ans,dp[i][j]); 
            }
        }
        return ans*ans;
    }
}