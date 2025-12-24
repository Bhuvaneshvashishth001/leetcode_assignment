class Solution {
    class tuple{
        int dist;
        int row;
        int col;
        public tuple(int dist,int row,int col){
            this.dist=dist;
            this.row=row;
            this.col=col;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        if(n==1 && m==1 && grid[n-1][m-1]==0){
            return 1;
        }
        int visited[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<tuple> queue = new LinkedList<>();
        if(grid[0][0] ==1 || grid[n-1][m-1] ==1){
            return -1;
        }
        queue.add(new tuple(0,0,0));
        int dr[] = {-1,-1,-1,0,0,1,1,1};
        int dc[] = {0,-1,1,-1,1,0,-1,1};
        while(!queue.isEmpty()){
            tuple t = queue.poll();
            int dis =t.dist;
            int row =t.row;
            int col =t.col;
            if(row == n-1 && col == m-1){
                return visited[n-1][m-1]+1;
            }
            for(int i=0 ;i<8 ;i++){
                int drow = row+dr[i];
                int dcol = col+dc[i];
                if(drow>=0 && drow<n && dcol>=0 && dcol<m && grid[drow][dcol]==0){
                    if(visited[drow][dcol]>dis+1){
                        visited[drow][dcol]=dis+1;
                        queue.add(new tuple(dis+1,drow,dcol));
                    }
                }
            }
        }
        return visited[n-1][m-1]==Integer.MAX_VALUE?-1:visited[n-1][m-1]+1;
    }
}