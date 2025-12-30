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
        if(grid[0][0] ==1 || grid[n-1][m-1]==1){
            return -1;
        }
        Queue<Tuple> queue = new LinkedList<>();
        if(grid[0][0] == 0){
            queue.add(new Tuple(0,0,0));
        }
        int visited[][] = new int[n][m];
        for(int arr[]:visited){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        int dr[] = {-1,-1,-1,0,0,1,1,1};
        int dc[] = {0,-1,1,-1,1,0,-1,1};
        while(!queue.isEmpty()){
            Tuple t = queue.poll();
            int x = t.row;
            int y = t.col;
            int dist = t.dis;
            if(x ==n-1 && y==m-1){
                visited[n-1][m-1]= dist+1;
                break;
            }
            for(int i=0;i<8;i++){
                int drow = x+dr[i];
                int dcol = y+dc[i];
                if(drow>=0 && drow<n && dcol>=0 && dcol<m && grid[drow][dcol]==0){
                    if(visited[drow][dcol]>dist+1){
                        visited[drow][dcol] = dist+1;
                        queue.add(new Tuple(drow,dcol,dist+1));
                    }
                }
            }
        }
        return visited[n-1][m-1] ==Integer.MAX_VALUE?-1:visited[n-1][m-1];
    }
}