class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int j = 0;
        int n = nums.length;
        long sum = 0;
        int maxLen = 0;
        while(j<n){
            sum += nums[j];
            while((long)nums[j]*(j-i+1)-sum > k){
                sum -= nums[i];
                i++;
            }
            maxLen = Math.max(maxLen,j-i+1);
            j++;
        }
        return maxLen;
    }
}