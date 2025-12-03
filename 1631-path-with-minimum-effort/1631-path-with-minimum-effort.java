class Solution {
    class Tuple {
        int row, col, effort;
        public Tuple(int row, int col, int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m]; 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> a.effort - b.effort);
        pq.add(new Tuple(0, 0, 0));
        dist[0][0] = 0;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};

        while (!pq.isEmpty()) {
            Tuple t = pq.poll();
            int row = t.row, col = t.col, effort = t.effort;

            if (row == n - 1 && col == m - 1) return effort;

            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    int nextEffort = Math.max(effort, Math.abs(heights[nr][nc] - heights[row][col]));
                    if (nextEffort < dist[nr][nc]) {
                        dist[nr][nc] = nextEffort;
                        pq.add(new Tuple(nr, nc, nextEffort));
                    }
                }
            }
        }
        return 0;
    }
}