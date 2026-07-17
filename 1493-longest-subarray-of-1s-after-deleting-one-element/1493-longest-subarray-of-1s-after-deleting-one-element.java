class Solution {
    public int longestSubarray(int[] nums) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        int zero = -1;
        int maxLen = 0;
        while(j<n){
            if(nums[j] == 0 && zero != -1){
                i = zero+1;
            }
            if(nums[j] == 0){
                zero = j;
            }
            maxLen = Math.max(maxLen ,zero == -1 ? j-i+1:j-i);
            j++;
        }
        return maxLen == n ? n-1:maxLen;
    }
}