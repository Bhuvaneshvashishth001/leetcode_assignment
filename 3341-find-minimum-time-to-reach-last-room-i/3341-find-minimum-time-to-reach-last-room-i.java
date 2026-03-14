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
    public int minTimeToReach(int[][] move) {
        int n = move.length;
        int m = move[0].length;
        int visited[][] =new int[n][m];
        PriorityQueue<tuple> queue = new PriorityQueue<>((a,b)->a.time-b.time);
        queue.add(new tuple(0,0,0));
        int dr[] = {-1,0,0,1};
        int dc[] = {0,-1,1,0};
        while(!queue.isEmpty()){
            tuple T = queue.poll();
            int x = T.row;
            int y = T.col;
            int t = T.time;
            if(visited[x][y]==1){
                continue;
            }
            visited[x][y]=1;
            if(x==n-1 && y==m-1){
                return t;
            }
            for(int i=0;i<4;i++){
                int drow = x+dr[i];
                int dcol = y+dc[i];
                if(drow>=0 && drow<n && dcol>=0 && dcol<m){
                    int nextTime = Math.max(t, move[drow][dcol]) + 1;
                    queue.add(new tuple(drow,dcol,nextTime));
                }
            }
        }
        return -1;
    }
}