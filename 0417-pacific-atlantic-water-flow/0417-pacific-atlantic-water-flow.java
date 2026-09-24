class Solution {
    int dr[] = {-1,0,0,1};
    int dc[] = {0,-1,1,0};
    public boolean bfs(int row, int col, int grid[][], boolean p, boolean a) {

    int n = grid.length;
    int m = grid[0].length;

    boolean[][] vis = new boolean[n][m];

    Queue<int[]> queue = new LinkedList<>();

    queue.add(new int[]{row, col});
    vis[row][col] = true;

    while (!queue.isEmpty()) {

        int[] pair = queue.poll();

        int sr = pair[0];
        int sc = pair[1];

        if (sr == 0 || sc == 0) {
            p = true;
        }

        if (sr == n - 1 || sc == m - 1) {
            a = true;
        }

        if (p && a) {
            return true;
        }

        for (int i = 0; i < 4; i++) {

            int drow = sr + dr[i];
            int dcol = sc + dc[i];

            if (drow >= 0 && drow < n &&
                dcol >= 0 && dcol < m &&
                grid[sr][sc] >= grid[drow][dcol] &&
                !vis[drow][dcol]) {

                vis[drow][dcol] = true;

                queue.add(new int[]{drow, dcol});
            }
        }
    }

    return false;
}
    public List<List<Integer>> pacificAtlantic(int[][] grid) {
        int n  = grid.length;
        int m = grid[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(bfs(i,j,grid,false,false)){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(new ArrayList<>(list));
                }
            }
        }
        return ans;
    }
}