class Solution {
    public boolean isPossible(int row,int col,char board[][],char ch){
        for(int i=0;i<9;i++){
            if(board[row][i] == ch ){
                return false;
            }
            if(board[i][col] == ch ){
                return false;
            }
        }
        int sr = row - (row % 3);
        int sc = col - (col % 3);
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(board[i][j] == ch){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean solve(int row,int col,char board[][]){
        if(row >= 9){
            return true;
        }
        if(col>=9){
            return solve(row+1,0,board);
        }
        if(board[row][col] !=  '.'){
            return solve(row,col+1,board);
        }
        for(char ch = '1' ; ch <= '9' ; ch++){
            if(isPossible(row,col,board,ch)){
                board[row][col] = ch;
                if(solve(row,col,board)){
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        solve(0,0,board);
    }
}