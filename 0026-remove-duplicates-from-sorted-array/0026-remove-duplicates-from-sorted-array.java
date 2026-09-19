class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int prev = 0;
        for(int i=1;i<n;i++){
            if(nums[i] != nums[prev]){
                prev++;
                nums[prev] = nums[i];
            }
        }
        return prev+1;
    }
}