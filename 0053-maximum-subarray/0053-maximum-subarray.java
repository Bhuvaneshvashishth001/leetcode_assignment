class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int sum = 0;
        for(int i=0;i<n;i++){
            sum = Math.max(sum+nums[i],nums[i]);
            max = Math.max(max,sum);
        }
        return max;
    }
}