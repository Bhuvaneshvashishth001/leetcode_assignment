class Solution {

    public boolean ispossible(char[][] grid, int row, int col, char val){
        for(int i=0;i<9;i++){
            if(grid[i][col] == val) return false;
            if(grid[row][i] == val) return false;
        }
        int sr = row - row % 3;
        int sc = col - col % 3;
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(grid[i][j] == val) return false;
            }
        }
        return true;
    }

    public boolean helper(char[][] grid, int row, int col){
        if(row == 9) return true;
        if(col == 9) return helper(grid, row+1, 0);
        if(grid[row][col] != '.') return helper(grid, row, col+1);

        for(char i='1'; i<='9'; i++){
            if(ispossible(grid, row, col, i)){
                grid[row][col] = i;
                if(helper(grid, row, col+1)) return true;
                grid[row][col] = '.';
            }
        }
        return false;
    }

    public void solveSudoku(char[][] grid) {
        helper(grid, 0, 0);
    }
}
