class Solution {
    public int rec(int idx,int canBuy,int arr[],int trans,int dp[][][]){
        if(idx >= arr.length || trans>=2){
            return 0;
        }
        if(dp[idx][canBuy][trans]!=-1){
            return dp[idx][canBuy][trans];
        }
        int pro=0;
        if(canBuy == 1){
            int buy = -arr[idx]+rec(idx+1,0,arr,trans,dp);
            int skip = rec(idx+1,1,arr,trans,dp);
            pro = Math.max(buy,skip);
        }
        else{
            int sell = arr[idx]+rec(idx+1,1,arr,trans+1,dp);
            int skip = rec(idx+1,0,arr,trans,dp);
            pro = Math.max(sell,skip);
        }
        return dp[idx][canBuy][trans] = pro;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n][2][2];
        for(int row[][]:dp){
            for(int d[]:row){
                Arrays.fill(d,-1);
            }
        }
        int canBuy = 1;
        return rec(0,canBuy,prices,0,dp);
    }
}