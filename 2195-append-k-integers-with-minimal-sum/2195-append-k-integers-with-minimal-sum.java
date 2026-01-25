class Solution {
    public long minimalKSum(int[] nums, int k) {
        int n = nums.length;
        int start =1;
        long sum =0;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(nums[i]<start){
                continue;
            }
            if(nums[i]>start){
                int gap = nums[i]-start;
                if(gap >= k){
                    long num = start+k-1;
                    sum = sum+ ((num*(num+1))/2-((long)start*(start-1)/2));
                    return sum;
                }
                else{
                    long num = nums[i]-1;
                    sum = sum+ ((num*(num+1))/2-((long)start*(start-1)/2));
                    k-=gap;
                }
            }
            start = nums[i]+1;
        }
        if(k>0){
            long num = start+k-1;
            sum += ((num*(num+1))/2-((long)start*(start-1)/2));
        }
        return sum;
    }
}