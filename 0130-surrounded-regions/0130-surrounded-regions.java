class Solution {

    public void dfs(int row, int col, char[][] grid, int[][] board) {
        board[row][col] = 1;
        int[] dr = {-1,0,0,1};
        int[] dc = {0,-1,1,0};
        for(int i=0;i<4;i++){

            int drow = row + dr[i];
            int dcol = col + dc[i];

            if(drow>=0 && drow<grid.length &&
               dcol>=0 && dcol<grid[0].length &&
               grid[drow][dcol]=='O' &&
               board[drow][dcol]==0){

                dfs(drow,dcol,grid,board);
            }
        }
    }

    public void solve(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] board = new int[n][m];

        for(int i=0;i<n;i++){

            if(grid[i][0]=='O' && board[i][0]==0)
                dfs(i,0,grid,board);

            if(grid[i][m-1]=='O' && board[i][m-1]==0)
                dfs(i,m-1,grid,board);
        }

        for(int j=0;j<m;j++){

            if(grid[0][j]=='O' && board[0][j]==0)
                dfs(0,j,grid,board);

            if(grid[n-1][j]=='O' && board[n-1][j]==0)
                dfs(n-1,j,grid,board);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(grid[i][j]=='O' && board[i][j]==0)
                    grid[i][j]='X';
            }
        }
    }
}