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
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<Tuple> queue = new LinkedList<>();
        int dist[][] = new int[n][m];
        for(int dis[]:dist){
            Arrays.fill(dis,Integer.MAX_VALUE);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    dist[i][j] =0;
                    queue.add(new Tuple(i,j,0));
                }
            }
        }
        int dr[] = {-1,0,0,1};
        int dc[] = {0,-1,1,0};
        while(!queue.isEmpty()){
            Tuple t = queue.poll();
            int x = t.row;
            int y = t.col;
            int d = t.dis;
            if(dist[x][y] <d){
                continue;
            }
            for(int i=0;i<4;i++){
                int drow = x+dr[i];
                int dcol = y+dc[i];
                if(drow>=0 && drow<n &&  dcol>=0 && dcol<m && mat[drow][dcol] ==1){
                    if(dist[drow][dcol] > d+1){
                        dist[drow][dcol] = d+1;
                        queue.add(new Tuple(drow,dcol,d+1));
                    }
                }
            }
        }
        
        return dist;
    }
}