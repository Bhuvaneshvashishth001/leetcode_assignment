class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int grid[][] = new int[n][n];
        for(int i=0;i<n;i++){
            int newrow[]= new int[n];
            int k=0;
            for(int j=n-1;j>=0;j--){
                newrow[k++] = matrix[j][i];
            }
            grid[i] = newrow;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = grid[i][j];
            }
        }
    }
}