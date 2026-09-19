class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int pre = 1;
        int suff =1;
        int max = Integer.MIN_VALUE;
        int i = 0;
        while(i<n){
            if(pre == 0){
                pre =1;
            }
            if(suff == 0){
                suff =1;
            }
            pre = pre*nums[i];
            suff = suff*nums[n-i-1];
            max= Math.max(max,Math.max(pre,suff));
            i++;
        }
        return max;
    }
}