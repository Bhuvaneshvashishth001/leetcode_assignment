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
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1){
            return -1;
        }
        int visited[][] = new int[n][n];
        for(int row[]:visited){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(0,0,1));
        int dr[] = {-1,-1,-1,0,0,1,1,1};
        int dc[] = {-1,0,1,-1,1,-1,0,1};
        visited[0][0] =1;
        while(!queue.isEmpty()){
            Tuple t = queue.poll();
            int x = t.row;
            int y = t.col;
            int dis = t.dis;
            if(x == n-1 && y == n-1){
                return dis;
            }
            for(int i=0;i<8;i++){
                int drow = x+dr[i];
                int dcol = y+dc[i];
                if(drow>=0 && drow<n && dcol >=0 && dcol<n && grid[drow][dcol] == 0){
                    if(visited[drow][dcol] > dis+1){
                        visited[drow][dcol] = dis+1;
                        queue.add(new Tuple(drow,dcol,dis+1));
                    }
                }
            }
        }
        return -1;
    }
}