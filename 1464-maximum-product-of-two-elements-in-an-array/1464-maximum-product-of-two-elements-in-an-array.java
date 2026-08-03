class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int f = nums[n-1]-1;
        int s = nums[n-2]-1;
        return f*s;
    }
}