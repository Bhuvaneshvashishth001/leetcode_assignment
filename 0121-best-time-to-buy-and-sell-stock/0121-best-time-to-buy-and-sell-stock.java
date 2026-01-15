class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int pro = 0;
        for(int i=0;i<n;i++){
            min = Math.min(min,arr[i]);
            pro = Math.max(pro,arr[i]-min);
        }
        return pro;
    }
}