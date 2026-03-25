class Solution {
    int dp[][];
    public int amount(int i,int j,int arr[]){
        if(i>j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ans = Integer.MIN_VALUE;
        for(int k=i;k<=j;k++){
            int collect = arr[i-1]*arr[k]*arr[j+1] + amount(i,k-1,arr)+amount(k+1,j,arr);
            ans = Math.max(ans,collect);
        }
        return dp[i][j] = ans;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int nums1[] = new int[n+2];
        nums1[0] = 1;
        nums1[n+1] = 1;
        dp = new int[n+1][n+1];
        for(int row[] :dp){
            Arrays.fill(row,-1);
        }
        for(int i=0;i<n;i++){
            nums1[i+1] =nums[i];
        }
        return amount(1,n,nums1);
    }
}