class Solution {
    class Tuple{
        int row;
        int col;
        int effort;
        public Tuple(int row,int col,int effort){
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
    }
    public int minimumEffortPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int Efforts[][] = new int[n][m];
        for(int row[] : Efforts){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        PriorityQueue<Tuple> queue = new PriorityQueue<>((a,b)->a.effort-b.effort);
        queue.add(new Tuple(0,0,0));
        Efforts[0][0] = 0;
        int dr[] = {-1,0,0,1};
        int dc[] = {0,-1,1,0};
        while(!queue.isEmpty()){
            Tuple t = queue.poll();
            int x = t.row;
            int y = t.col;
            int eff = t.effort;
            if(x == n-1 && y == m-1){
                return eff;
            }
            for(int i=0;i<4;i++){
                int drow = x+dr[i];
                int dcol = y+dc[i];
                if(drow >= 0 && drow <n && dcol >= 0 && dcol <m){
                    if(Efforts[drow][dcol] > Math.max(eff,Math.abs(grid[x][y] - grid[drow][dcol]))){
                        Efforts[drow][dcol] = Math.max(eff,Math.abs(grid[x][y] - grid[drow][dcol]));
                        queue.add(new Tuple(drow,dcol,Efforts[drow][dcol]));
                    }
                }
            }
        }
        return -1;
    }
}