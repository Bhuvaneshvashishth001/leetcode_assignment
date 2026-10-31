class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(prices[i]<max){
                profit += (max-min);
                min = prices[i];
                max = prices[i];
            }
            min = Math.min(min,prices[i]);
            max = Math.max(max,prices[i]);
        }
        profit += max-min;
        return profit;
    }
}