class Solution {

    int dp[][];

    public int health(int sr, int sc, int er, int ec, int dungeon[][]) {

        if(sr == er && sc == ec) {
            return Math.max(1, 1 - dungeon[sr][sc]);
        }

        if(dp[sr][sc] != Integer.MAX_VALUE) {
            return dp[sr][sc];
        }

        int right = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;

        if(sc + 1 <= ec) {
            right = health(sr, sc + 1, er, ec, dungeon);
        }

        if(sr + 1 <= er) {
            down = health(sr + 1, sc, er, ec, dungeon);
        }

        int need = Math.min(right, down);

        dp[sr][sc] = Math.max(1, need - dungeon[sr][sc]);

        return dp[sr][sc];
    }

    public int calculateMinimumHP(int[][] dungeon) {

        int n = dungeon.length;
        int m = dungeon[0].length;

        dp = new int[n][m];

        for(int row[] : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        return health(0, 0, n - 1, m - 1, dungeon);
    }
}