class Solution {
    class Tuple{
        int row;
        int col;
        int dis;
        public Tuple(int row,int col,int dis){
            this.row = row;
            this.col = col;
            this.dis = dis;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0] ==1){
            return -1;
        }
        if(n-1 ==0 && m-1 ==0){
            return 1;
        }
        int clone[][] = new int[n][m];
        for(int edge[]:clone){
            Arrays.fill(edge,Integer.MAX_VALUE);
        }
        PriorityQueue<Tuple> queue = new PriorityQueue<>((a,b)->a.dis-b.dis);
        queue.add(new Tuple(0,0,1));
        int dr[] = {-1,-1,-1,0,0,1,1,1};
        int dc[] = {-1,0,1,-1,1,-1,0,1};
        while(!queue.isEmpty()){
            Tuple t = queue.poll();
            int x = t.row;
            int y = t.col;
            int dist = t.dis;
            for(int i=0;i<8;i++){
                int drow = x+dr[i];
                int dcol = y+dc[i];
                if(drow>=0 && drow<n && dcol>=0 && dcol<m && grid[drow][dcol]==0 && clone[drow][dcol] > dist+1){
                    clone[drow][dcol] = dist+1;
                    queue.add(new Tuple(drow,dcol,dist+1));
                }
            }
        }
        return clone[n-1][m-1] == Integer.MAX_VALUE ? -1:clone[n-1][m-1];
    }
}