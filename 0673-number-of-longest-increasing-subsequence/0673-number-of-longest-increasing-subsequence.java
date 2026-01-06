class Solution {
    public int findNumberOfLIS(int[] arr) {
        int n = arr.length;
        int dp[] = new int[n];
        int count[] = new int[n];
        for(int i=0;i<n;i++){
            dp[i] =1;
            count[i]=1;
        }
        int max =1;
        for(int i=1;i<n;i++){
            int ele= arr[i];
            for(int j=0;j<i ;j++){
                if(ele>arr[j]){
                    if(dp[i]<dp[j]+1){
                        dp[i] = dp[j]+1;
                        count[i] = count[j];
                    }
                    else if(dp[i] == dp[j]+1){
                        count[i] += count[j];
                    }
                }
            }
            max = Math.max(dp[i],max);
        }
        int total =0;
        for(int i=0;i<n;i++){
            if(dp[i]==max) {
                total+=count[i];
            }
        }
        return total;
    }
}