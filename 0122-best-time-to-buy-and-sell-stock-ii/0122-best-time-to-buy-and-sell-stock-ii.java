class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length;
        int dp[] = new int [n];
        dp[0]= 0;
        int min = arr[0];
        int pro = 0;
        for(int i=1;i<n;i++){
            if(arr[i]<min){
                min = arr[i];
                dp[i] = dp[i-1];
            }
            else{
                pro = (arr[i]-min);
                dp[i] = dp[i-1]+pro;
                min  = arr[i];
            }
        }
        return dp[n-1];
    }
}