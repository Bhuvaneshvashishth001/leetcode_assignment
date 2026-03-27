class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int mod = 12345;
        int pre[][] = new int[n][m];
        int suf[][] = new int[n][m];
        pre[0][0] = grid[0][0] % mod;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) continue;
                int pi = i, pj = j - 1;
                if (pj < 0) {
                    pi = i - 1;
                    pj = m - 1;
                }
                pre[i][j] = (int)(((long)pre[pi][pj] * grid[i][j]) % mod);
            }
        }
        suf[n-1][m-1] = grid[n-1][m-1] % mod;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) continue;
                int ni = i, nj = j + 1;
                if (nj == m) {
                    ni = i + 1;
                    nj = 0;
                }
                suf[i][j] = (int)(((long)suf[ni][nj] * grid[i][j]) % mod);
            }
        }
        int res[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                long left = 1, right = 1;
                if (!(i == 0 && j == 0)) {
                    int pi = i, pj = j - 1;
                    if (pj < 0) {
                        pi = i - 1;
                        pj = m - 1;
                    }
                    left = pre[pi][pj];
                }
                if (!(i == n - 1 && j == m - 1)) {
                    int ni = i, nj = j + 1;
                    if (nj == m) {
                        ni = i + 1;
                        nj = 0;
                    }
                    right = suf[ni][nj];
                }
                res[i][j] = (int)((left * right) % mod);
            }
        }
        return res;
    }
}