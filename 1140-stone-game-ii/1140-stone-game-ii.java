class Solution {
    int dp[][][];
    public int game(int arr[],int idx,int m,int chance){
        if(idx >= arr.length){
            return 0;
        }
        if(dp[idx][m][chance] != -1){
            return dp[idx][m][chance];
        }
        int ans;
        if(chance == 0){
            ans = 0;
            int sum = 0;
            for(int i=idx;i<idx+2*m && i<arr.length;i++){
                sum += arr[i];
                ans = Math.max(ans,sum+game(arr,i+1,Math.max(m,i-idx+1),1));
            }
        }
        else{
            ans = Integer.MAX_VALUE;
            int sum = 0;
            for(int i=idx;i<idx+2*m && i<arr.length;i++){
                sum += arr[i];
                ans = Math.min(ans,game(arr,i+1,Math.max(m,i-idx+1),0));
            }
        }
        return dp[idx][m][chance] = ans;
    }
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        dp = new int[n][n+1][2];
        for(int rows[][]:dp){
            for(int row[]:rows){
                Arrays.fill(row,-1);
            }
        }
        return game(piles,0,1,0);
    }
}