class Solution {
    public List<String> generate(int board[][],int n){
        List<String> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++){
                if(board[i][j] == 1){
                    sb.append("Q");
                }
                else{
                    sb.append(".");
                }
            }
            list.add(sb.toString());
        }
        return list;
    }
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
        r1 = row ;
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
        while(r1 >=0){
            if(board[r1][c1] == 1){
                return false;
            }
            r1--;
        }
        return true;
    }
    public void solve(int col,int n,int board[][],List<List<String>> ans){
        if(col >= n ){
            ans.add(new ArrayList<>(generate(board,n)));
            return;
        }
        for(int row = 0; row < n ; row++){
            if(isSafe(row,col,board,n)){
                board[row][col] = 1;
                solve(col+1,n,board,ans);
                board[row][col] = 0;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int board[][] = new int[n][n];
        solve(0,n,board,ans);
        return ans;
    }
}