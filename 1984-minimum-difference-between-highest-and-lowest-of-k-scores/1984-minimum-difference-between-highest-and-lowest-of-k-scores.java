class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans =Integer.MAX_VALUE;
        for(int i=0;i<=n-k;i++){
            int min = nums[i];
            int max = nums[i+k-1];
            ans = Math.min(ans,max-min);
        }
        return ans;
    }
}