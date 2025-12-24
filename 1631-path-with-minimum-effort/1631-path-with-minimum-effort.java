class Solution {
    class Tuple{
        int row;
        int col;
        int eff;
        public Tuple(int row,int col,int eff){
            this.row = row;
            this.col = col;
            this.eff = eff;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int grid[][] = new int[n][m];
        if(n-1 ==0 && m-1 ==0){
            return 0;
        }
        for(int edge[] : grid){
            Arrays.fill(edge,Integer.MAX_VALUE);
        }
        PriorityQueue<Tuple> queue = new PriorityQueue<>((a,b)->a.eff-b.eff);
        queue.add(new Tuple(0,0,0));
        int dr[] = {-1,0,1,0};
        int dc[] = {0,-1,0,1};
        while(!queue.isEmpty()){
            Tuple t = queue.poll();
            int x = t.row;
            int y = t.col;
            int effort = t.eff;
            for(int i=0;i<4;i++){
                int drow = x+dr[i];
                int dcol = y+dc[i];
                if(drow >= 0 && drow <n && dcol>=0 && dcol<m && grid[drow][dcol]>effort){
                    int newEff = Math.abs(heights[drow][dcol]-heights[x][y]);
                    if(newEff>effort){
                        grid[drow][dcol] = newEff;
                        queue.add(new Tuple(drow,dcol,newEff));
                    }
                    else{
                        grid[drow][dcol] = effort;
                        queue.add(new Tuple(drow,dcol,effort));
                    }
                }
            }
        }
        return grid[n-1][m-1];
    }
}