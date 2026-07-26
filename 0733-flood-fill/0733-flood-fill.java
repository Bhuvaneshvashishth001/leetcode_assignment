class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr,sc});
        int org = image[sr][sc];
        image[sr][sc] = color;
        int dr[] = {-1,0,0,1};
        int dc[] = {0,-1,1,0};
        while(!queue.isEmpty()){
            int edge[] = queue.poll();
            int x = edge[0];
            int y = edge[1];
            for(int i=0;i<4;i++){
                int drow = x+dr[i];
                int dcol = y+dc[i];
                if(drow>=0 && drow<n && dcol >=0 && dcol<m && image[drow][dcol] == org && image[drow][dcol] != color){
                    image[drow][dcol] = color;
                    queue.add(new int[]{drow,dcol});
                }
            }
        }
        return image;
    }
}