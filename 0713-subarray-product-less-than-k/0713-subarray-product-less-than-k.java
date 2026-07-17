class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int  i =0;
        int j = 0;
        int  n = nums.length;
        int pro =1;
        int total = 0;
        while(j<n){
            pro = pro*nums[j];
            while(pro >= k && j>= i){
                pro = pro/nums[i];
                i++;
            }
            total += (j-i+1);
            j++;
        }   
        return total;
    }
}