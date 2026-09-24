class Solution {
    class tuple{
        int row;
        int col;
        int time;
        public tuple(int row,int col,int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        Queue<tuple> queue = new LinkedList<>();
        int fresh = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                else if(grid[i][j] == 2){
                    vis[i][j] =2;
                    queue.add(new tuple(i,j,0));
                }
                else{
                    vis[i][j] =2;
                }
            }
        }
        int dr[] = {-1,0,0,1};
        int dc[] = {0,-1,1,0};
        int ans = 0;
        while(!queue.isEmpty()){
            tuple t = queue.poll();
            int x = t.row;
            int y = t.col;
            int time = t.time;
            ans = Math.max(ans,time);
            for(int i=0;i<4;i++){
                int drow = x+dr[i];
                int dcol = y+dc[i];
                if(drow>=0 && drow<n && dcol >=0 && dcol <m && vis[drow][dcol] != 2){
                    vis[drow][dcol] = 2;
                    fresh--;
                    queue.add(new tuple(drow,dcol,time+1));
                }
            }
        }
        if(fresh > 0){
            return -1;
        }
        return  ans;
    }
}