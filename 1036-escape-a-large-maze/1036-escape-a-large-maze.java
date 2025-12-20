class Solution {
    static final int LIMIT = 1_000_000;
    static final int MAX = 20000;
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> block = new HashSet<>();
        for (int[] b:blocked) {
            block.add(b[0] + "," + b[1]);
        }
        return bfs(source,target,block) && bfs(target,source,block);
    }
    private boolean bfs(int[] start,int[] finish,Set<String> blocked) {
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        Set<String> vis = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        vis.add(start[0] + "," + start[1]);
        while(!q.isEmpty() && vis.size()<=MAX){
            int[] cur = q.poll();
            if(cur[0]==finish[0] && cur[1]==finish[1]){
                return true;
            }
            for(int[] d : dir){
                int nr = cur[0]+d[0];
                int nc = cur[1]+d[1];
                String key = nr+","+nc;
                if (nr >= 0 && nr<LIMIT && nc>=0 && nc<LIMIT && !blocked.contains(key) && !vis.contains(key)){
                    vis.add(key);
                    q.add(new int[]{nr, nc});
                }
            }
        }
        return vis.size()>MAX;
    }
}
