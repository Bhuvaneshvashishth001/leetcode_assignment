class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        int n = nums.length;
        long total = 0;
        for(int i=0;i<n;i++){
            total += nums[i];
        }
        long need = Math.abs(total-goal);
        System.out.println(need);
        long ans = (long)Math.ceil((double)need/limit);
        return (int)ans;
    }
}