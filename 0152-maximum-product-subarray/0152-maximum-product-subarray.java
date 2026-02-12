class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        for(int i=0;i<n;i++){
            int pro = nums[i];
            max= Math.max(max,pro);
            for(int j=i+1;j<n;j++){
                pro=pro*nums[j];
                max = Math.max(max,pro);
            }
        }
        return max;
    }
}