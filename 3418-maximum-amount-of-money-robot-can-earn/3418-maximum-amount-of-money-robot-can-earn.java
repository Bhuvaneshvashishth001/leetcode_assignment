import java.util.*;

class Solution {
    int dr[] = {1,0};
    int dc[] = {0,1};
    int dp[][][];

    public int helper(int sr,int sc,int er,int ec,int coins[][],int countNeglect){

        if(sr == er && sc == ec){
            if(coins[sr][sc] < 0 && countNeglect < 2) return 0;
            return coins[sr][sc];
        }

        if(dp[sr][sc][countNeglect] != Integer.MIN_VALUE){
            return dp[sr][sc][countNeglect];
        }

        int best = Integer.MIN_VALUE;

        for(int i=0;i<2;i++){
            int drow = sr + dr[i];
            int dcol = sc + dc[i];

            if(drow < coins.length && dcol < coins[0].length){

                int next = helper(drow,dcol,er,ec,coins,countNeglect);

                if(coins[sr][sc] >= 0){
                    best = Math.max(best, coins[sr][sc] + next);
                } 
                else {
                    if(countNeglect < 2){
                        int skip = helper(drow,dcol,er,ec,coins,countNeglect+1);
                        int take = coins[sr][sc] + next;
                        best = Math.max(best, Math.max(skip, take));
                    } else {
                        best = Math.max(best, coins[sr][sc] + next);
                    }
                }
            }
        }

        return dp[sr][sc][countNeglect] = best;
    }

    public int maximumAmount(int[][] coins) {
        int n = coins.length;
        int m = coins[0].length;

        dp = new int[n][m][3];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }

        return helper(0,0,n-1,m-1,coins,0);
    }
}