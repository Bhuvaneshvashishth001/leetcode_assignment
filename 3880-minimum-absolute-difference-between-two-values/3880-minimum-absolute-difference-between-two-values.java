class Solution {
    public int minAbsoluteDifference(int[] nums) {
        int n = nums.length;
        int one = -1;
        int two = -1;
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i] == 1){
                one = i;
            }
            if(nums[i] == 2){
                two = i;
            }
            if(one != -1 && two != -1){
                ans = Math.min(ans,Math.abs(two-one));
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}