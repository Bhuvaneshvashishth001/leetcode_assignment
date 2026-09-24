class Solution {
    int dr[] = {-1,0,0,1};
    int dc[] = {0,-1,1,0};
    public void dfs(int row,int col,char board[][],int vis[][]){
        vis[row][col] = 1;
        for(int i= 0;i<4 ;i++){
            int drow = row+dr[i];
            int dcol = col+dc[i];
            if(drow >= 0 && drow <board.length && dcol >= 0 && dcol <board[0].length && board[drow][dcol] == 'O' && vis[drow][dcol] == 0){
                vis[drow][dcol] =1;
                dfs(drow,dcol,board,vis);
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int vis[][] = new int[n][m];
        for(int i=0;i<n;i++){
            if(board[i][0] == 'O'){
                dfs(i,0,board,vis);
            }
            if(board[i][m-1] == 'O'){
                dfs(i,m-1,board,vis);
            }
        }
        for(int i=0;i<m;i++){
            if(board[0][i] == 'O'){
                dfs(0,i,board,vis);
            }
            if(board[n-1][i] == 'O'){
                dfs(n-1,i,board,vis);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == 'O' && vis[i][j] == 1){
                    board[i][j] = 'O';
                }
                else{
                    board[i][j] = 'X';
                }
            }
        }
    }
}