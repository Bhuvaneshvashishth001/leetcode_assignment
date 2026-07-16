class Solution {
    public double findMaxAverage(int[] arr, int k) {
        int n = arr.length;
        double maxAvg = (double)Integer.MIN_VALUE;
        double sum = 0;
        for(int i=0;i<k;i++){
            sum += arr[i];
        }
        maxAvg = Math.max(maxAvg,sum/k);
        for(int i=k ;i<n;i++){
            sum = sum+arr[i]-arr[i-k];
            maxAvg = Math.max(maxAvg,sum/k);
        }
        return maxAvg;
    }
}