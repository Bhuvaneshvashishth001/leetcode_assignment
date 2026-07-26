class Solution {
    class Pair{
        int row;
        int col;
        int dis;
        public Pair(int row,int col,int dis){
            this.row = row;
            this.col = col;
            this.dis = dis;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n  = mat.length;
        int m = mat[0].length;
        int grid[][] = new int[n][m];
        int visited[][] = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    queue.add(new Pair(i,j,0));
                    visited[i][j] =1;
                }
            }
        }
        int dr[] = {-1,0,0,1};
        int dc[] = {0,-1,1,0};
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int x = p.row;
            int y = p.col;
            int step = p.dis;
            for(int i=0;i<4;i++){
                int drow = x+dr[i];
                int dcol = y+dc[i];
                if(drow>= 0 && drow<n && dcol>=0 && dcol<m && visited[drow][dcol] == 0){
                    mat[drow][dcol] = step+1;
                    queue.add(new Pair(drow,dcol,step+1));
                    visited[drow][dcol] = 1;
                }
            }
        }
        return mat;
     }
}