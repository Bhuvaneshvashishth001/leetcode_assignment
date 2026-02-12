class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int maxS = nums[0];
        int minS = nums[0];
        int cMax = 0;
        int cMin = 0;
        int total = 0;
        for(int i=0;i<n;i++){
            cMax = Math.max(cMax+nums[i],nums[i]);
            maxS = Math.max(maxS,cMax);
            cMin = Math.min(cMin+nums[i],nums[i]);
            minS = Math.min(minS,cMin);
            total += nums[i];
        }
        if(maxS>0){
            return Math.max(maxS,total-minS);
        }
        return maxS;
    }
}