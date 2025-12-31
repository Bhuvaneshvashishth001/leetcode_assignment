class Solution {
    class Tuple{
        int row;
        int col;
        int heal;
        public Tuple(int row,int col,int heal){
            this.row = row;
            this.col = col;
            this.heal = heal;
        }
    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();
        int visited[][] = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(visited[i], -1);
        }
        if(grid.get(0).get(0) ==0){
            visited[0][0] = health;
        }
        else{
            visited[0][0] = health-1;
        }
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(0,0,visited[0][0]));
        int dr[] ={-1,0,0,1};
        int dc[] ={0,-1,1,0};
        while(!queue.isEmpty()){
            Tuple t = queue.poll();
            int x = t.row;
            int y = t.col;
            int h = t.heal;
            for(int i=0;i<4;i++){
                int drow = x+dr[i];
                int dcol = y+dc[i];
                if(drow>=0 && drow<n && dcol>=0 && dcol<m){
                    if(visited[drow][dcol]<h-grid.get(drow).get(dcol)){
                        visited[drow][dcol] = h-grid.get(drow).get(dcol);
                        queue.add(new Tuple(drow,dcol,h-grid.get(drow).get(dcol)));
                    }
                }
            }
        }
        if(visited[n-1][m-1]>=1){
            return true;
        }
        return false;
    }
}