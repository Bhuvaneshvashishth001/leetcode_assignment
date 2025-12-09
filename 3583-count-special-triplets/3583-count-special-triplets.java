class Solution {
    public int specialTriplets(int[] nums) {
        int MOD = 1_000_000_007;
        int maxVal =100000;
        long ans=0;
        int []r = new int[maxVal+1];
        int []l = new int [maxVal+1];
        for(int num:nums){
            r[num]++;
        }
        for(int j=0;j<nums.length;j++){
            int mid= nums[j];
            long target =(long) mid*2;
            r[mid]--;
            if(target <= maxVal){
                ans = (ans +((long)l[(int)target] * r[(int) target])%MOD)%MOD;
            }
            l[mid]++;
        }
        return (int)ans;
    }
}