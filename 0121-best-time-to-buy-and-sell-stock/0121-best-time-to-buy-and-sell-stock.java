class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int pro = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            minPrice = Math.min(prices[i],minPrice);
            pro = Math.max(pro,prices[i]-minPrice);
        }
        return pro;
    }
}