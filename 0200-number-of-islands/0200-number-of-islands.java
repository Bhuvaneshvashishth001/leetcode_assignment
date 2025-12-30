class Solution {
    public static void dfs(int row,int col,char mat[][],int visited[][]){
        visited[row][col] =1;
        int dr[] = {-1,0,0,1};
        int dc[] = {0,-1,1,0};
        for(int i=0;i<4;i++){
            int drow = row+dr[i];
            int dcol = col+dc[i];
            if(drow>=0 && drow<mat.length && dcol>=0 && dcol<mat[0].length && mat[drow][dcol] =='1' && visited[drow][dcol]!=1){
                dfs(drow,dcol,mat,visited);
            }
        }
    }
    public int numIslands(char[][] mat) {
        int  n =mat.length;
        int m = mat[0].length;
        int visited[][] = new int[n][m];
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] =='1' && visited[i][j]!=1){
                    dfs(i,j,mat,visited);
                    count++;
                }
                else{
                    visited[i][j] =1;
                }
            }
        }
        return count;
    }
}