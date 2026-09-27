class Solution {
    public boolean isPossible(int num,int nums[],int limit){
        int total = 0;
        for(int value : nums){
            total += (int)Math.ceil((double)value/num);
        }
        return total<=limit;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int max = 0;
        for(int num:nums){
            max = Math.max(max,num);
        }
        int n = nums.length;
        int start = 1;
        int end = max;
        int ans = max;
        while(start <= end){
            int mid = start+(end-start)/2;
            if(isPossible(mid,nums,threshold)){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;
    }
}