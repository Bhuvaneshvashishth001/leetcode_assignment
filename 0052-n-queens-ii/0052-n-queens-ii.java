class Solution {
    public boolean isSafe(int row,int col,int board[][],int n){
        int r1 = row;
        int c1 = col;
        while(r1>=0 && c1>=0){
            if(board[r1][c1] == 1){
                return false;
            }
            r1--;
            c1--;
        }
        r1 = row;
        c1 = col;
        while(r1<n && c1>=0){
            if(board[r1][c1] == 1){
                return false;
            }
            r1++;
            c1--;
        }
        r1 = row;
        c1 = col;
        while(c1>=0){
            if(board[r1][c1] == 1){
                return false;
            }
            c1--;
        }
        r1 = row;
        c1 = col;
        while(r1>=0){
            if(board[r1][c1] ==1){
                return false;
            }
            r1--;
        }
        return true;
    }
    public int helper(int col,int board[][],int n){
        if(col >= n){
            return 1;
        }
        int count = 0;
        for(int row =0;row<n;row++){
            if(isSafe(row,col,board,n)){
                board[row][col] =1;
                count += helper(col+1,board,n);
                board[row][col] = 0;
            }
        }
        return count;
    }
    public int totalNQueens(int n) {
        int board[][] = new int[n][n];
        int ans = helper(0,board,n);
        return ans;
    }
}