class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min = prices[0];
        int ans = 0;
        for(int i=1;i<n;i++){
            ans = Math.max(prices[i]-min,ans);
            min = Math.min(min,prices[i]);
        }
        return ans;
    }
}