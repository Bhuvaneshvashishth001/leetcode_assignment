class Solution {
    int dr[] = {-1,0,0,1};
    int dc[] = {0,-1,1,0};
    public boolean helper(int sr,int sc,int k,char board[][],String str,boolean vis[][]){
        if(k == str.length()){
            return true;
        }
        for(int i=0;i<4;i++){
            int drow = sr+dr[i];
            int dcol = sc+dc[i];
            if(drow >= 0 && drow<board.length && dcol>=0 && dcol < board[0].length && board[drow][dcol] == str.charAt(k) && vis[drow][dcol] == false){
                vis[drow][dcol] = true;
                if(helper(drow,dcol,k+1,board,str,vis)){
                    return true;
                }
                vis[drow][dcol] = false;
            }
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean vis[][] = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == word.charAt(0)){
                    vis[i][j] = true;
                    if(helper(i,j,1,board,word,vis)){
                        return true;
                    }
                    vis[i][j] = false;
                }
            }
        }
        return false;
    }
}