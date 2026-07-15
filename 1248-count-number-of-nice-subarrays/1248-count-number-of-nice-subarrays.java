class Solution {
    public int subarray(int nums[] ,int k){
        int i = 0;
        int j = 0;
        int odd = 0;
        int n = nums.length;
        int count = 0;
        while(j<n){
            if(nums[j] %2 != 0){
                odd++;
            }
            while(odd >k){
                if(nums[i] %2 != 0){
                    odd--;
                }
                i++;
            }
            count += j-i+1;
            j++;
        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        int  n = nums.length;
        return subarray(nums,k) - subarray(nums,k-1);
    }
}