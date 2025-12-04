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
    public int minimumEffortPath(int[][] height) {
        int n = height.length;
        int m = height[0].length;
        int visited[][]= new int[n][m];
        for(int arr[]:visited){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        PriorityQueue<Tuple> queue = new PriorityQueue<>((a,b)->a.eff-b.eff);
        queue.add(new Tuple(0,0,0));
        int dr[] = {-1,0,0,1};
        int dc[] = {0,-1,1,0};
        while(!queue.isEmpty()){
            Tuple t = queue.poll();
            int x= t.row;
            int y= t.col;
            int diff = t.eff;
            if(x ==n-1 && y == m-1){
                return diff;
            }
            for(int i=0;i<4;i++){
                int drow = x+dr[i];
                int dcol = y+dc[i];
                if(drow>=0 && drow<n && dcol>=0 && dcol<m){
                    int node = height[x][y];
                    int ele = height[drow][dcol];
                    int nexeff = Math.max(diff,Math.abs(ele-node));
                    if(visited[drow][dcol]>nexeff){
                        visited[drow][dcol] = nexeff;
                        queue.add(new Tuple(drow,dcol,nexeff));
                    }
                }
            }
        }
        return -1;
    }
}