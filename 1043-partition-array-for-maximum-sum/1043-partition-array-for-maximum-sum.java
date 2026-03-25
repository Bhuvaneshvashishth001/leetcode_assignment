class Solution {
    int dp[];
    public int helper(int i,int arr[],int k){
        if(i == arr.length){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int maxAns = Integer.MIN_VALUE;
        int len = 0;
        int max = Integer.MIN_VALUE;
        for(int idx = i;idx<Math.min(arr.length,i+k);idx++){
            len++;
            max = Math.max(max,arr[idx]);
            int sum = max*len+helper(idx+1,arr,k);
            maxAns = Math.max(sum,maxAns);
        }
        return dp[i] = maxAns;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        dp = new int[n];
        Arrays.fill(dp,-1);
        return helper(0,arr,k);
    }
}