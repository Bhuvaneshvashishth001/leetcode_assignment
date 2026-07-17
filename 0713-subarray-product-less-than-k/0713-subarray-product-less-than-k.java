class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int pro = 1;
        int i=0;
        int j=0;
        int total = 0;
        while(j<nums.length){
            pro  = pro*nums[j];
            while(pro>=k && i<=j){
                pro/=nums[i];
                i++;
            }
            total+=(j-i+1);
            j++;
        }
        return total;
    }
}