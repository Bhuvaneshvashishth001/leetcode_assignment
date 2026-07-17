class Solution {
    public int longestSubarray(int[] nums) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        int zero = 0;
        int maxLen = 0;
        while(j<n){
            while(zero == 1 && nums[j] == 0){
                if(nums[i] == 0){
                    zero--;
                }
                i++;
            }
            if(nums[j] == 0){
                zero++;
            }
            maxLen = Math.max(maxLen ,j-i+1-zero);
            j++;
        }
        return maxLen == n ? n-1:maxLen;
    }
}