class Solution {
    public boolean isSafe(int board[][],int row,int col,int n){
        int r = row;
        int c = col;
        while(r>=0 && c>=0){
            if(board[r][c] == 1){
                return false;
            }
            r--;
            c--;
        }
        r = row;
        c = col;
        while(r<n && c>=0){
            if(board[r][c] == 1){
                return false;
            }
            r++;
            c--;
        }
        r = row;
        c = col;
        while(c>=0){
            if(board[r][c] == 1){
                return false;
            }
            c--;
        }
        return true;
    }
    public int helper(int board[][],int col,int n){
        if(col>= board.length){
            return 1;
        }
        int count = 0;
        for(int i=0;i<n;i++){
            if(isSafe(board,i,col,n)){
                board[i][col] = 1;
                count += helper(board,col+1,n);
                board[i][col] = 0;
            }
        }
        return count;
    }
    public int totalNQueens(int n) {
        int board[][] = new int[n][n];
        return helper(board,0,n);
    }
}