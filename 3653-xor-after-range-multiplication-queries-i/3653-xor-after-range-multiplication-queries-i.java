class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        long mod = (long)1000000007;
        int n = nums.length;
        for(int i=0;i<queries.length;i++){
            int idx = queries[i][0];
            while(idx<=queries[i][1]){
                long a = (long)nums[idx];
                long b = (long)queries[i][3];
                long val = (long)(a*b)%mod;
                nums[idx] = (int)val;
                idx += queries[i][2]; 
            }
        }
        long ans = nums[0];
        for(int i=1;i<n;i++){
            ans = ans^(long)nums[i];
        }
        return (int)ans;
    }
}