class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int preSum[] = new int[n];
        preSum[0] = nums[0];
        for(int i=1;i<n;i++){
            preSum[i] = preSum[i-1]+nums[i];
        }
        int total = preSum[n-1];
        int first = 0;
        int second = 0;
        int count =0;
        for(int i=0;i<n-1;i++){
            first = preSum[i];
            second = total - first;
            if((Math.abs(second -first))%2 == 0){
                count++;
            }
        }
        return count;
    }
}