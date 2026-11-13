class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int sd = 1;
        int si = 1;
        int max = 1;
        for(int i=1;i<n;i++){
            if(nums[i-1]<nums[i]){
                sd = 1;
                si++;
            }
            else if(nums[i-1]>nums[i]){
                sd++;
                si =1;
            }
            else{
                sd = 1;
                si = 1;
            }
            max = Math.max(max,Math.max(si,sd));
        }
        return max;
    }
}