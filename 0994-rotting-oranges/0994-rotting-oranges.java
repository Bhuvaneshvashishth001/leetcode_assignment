class Solution {
    class Pair{
        int row;
        int col;
        int time;
        public Pair(int row,int col,int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int matrix[][] = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();
        int freshOrange = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    queue.add(new Pair(i,j,0));
                    matrix[i][j] = 1;
                }
                if(grid[i][j] == 1){
                    freshOrange++;
                }
                if(grid[i][j] == 0){
                    matrix[i][j] =1;
                }
            }
        }
        int dr[] = {-1,0,0,1};
        int dc[] = {0,-1,1,0};
        int min = 0;
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int x = p.row;
            int y = p.col;
            int t = p.time;
            min = Math.max(min,t);
            for(int i=0;i<4;i++){
                int drow = x+dr[i];
                int dcol = y+dc[i];
                if(drow>=0 && dcol>=0 && drow <n && dcol<m && matrix[drow][dcol] == 0 && grid[drow][dcol] == 1){
                    matrix[drow][dcol] =1;
                    freshOrange--;
                    queue.add(new Pair(drow,dcol,t+1));
                }
            }
        }
        if(freshOrange != 0){
            return -1;
        } 
        return min;
    }
}