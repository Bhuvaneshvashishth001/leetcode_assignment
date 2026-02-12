class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int cMin = nums[0];
        int cMax = nums[0];
        int max = nums[0];
        for(int i=1;i<n;i++){
            int val = nums[i];
            if(val<0){
                int temp = cMin;
                cMin = cMax;
                cMax = temp;
            }
            cMax = Math.max(cMax*val,val);
            cMin = Math.min(cMin*val,val);
            max = Math.max(max,cMax);
        }
        return max;
    }
}