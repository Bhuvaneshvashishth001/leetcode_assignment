class Solution {
    class Pair{
        int dis;
        int row;
        int col;
        public Pair(int dis,int row,int col){
            this.dis = dis;
            this.row = row;
            this.col = col;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0] ==1 || grid[n-1][m-1] ==1){
            return -1;
        }
        int visited[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0,0,0));
        visited[0][0]=0;
        int dr[] = {-1,-1,-1,0,0,1,1,1};
        int dc[] = {0,-1,1,-1,1,0,-1,1};
        while(!queue.isEmpty()){
            Pair P = queue.poll();
            int x = P.row;
            int y = P.col;
            int dis = P.dis;
            if(x==n-1 && y==m-1){
                return visited[n-1][m-1]+1;
            }
            for(int i=0;i<8;i++){
                int drow=x+dr[i];
                int dcol=y+dc[i];
                if(drow>=0 && drow<n && dcol>=0 && dcol<m && grid[drow][dcol]==0){ 
                    if(visited[drow][dcol]>dis+1){
                        visited[drow][dcol]=dis+1;
                        queue.offer(new Pair(dis+1,drow,dcol));
                    }
                }
            }
        }
        return visited[n-1][m-1] == Integer.MAX_VALUE?-1:visited[n-1][m-1]+1;
    }
}