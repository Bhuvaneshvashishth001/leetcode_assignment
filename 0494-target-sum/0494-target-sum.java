class Solution {
    public int helper(int arr[],int idx,int target){
        if(idx == arr.length && target ==0){
            return 1;
        }
        if(idx >= arr.length){
            return 0;
        }
        int count =0;
        count += helper(arr,idx+1,target-arr[idx]);
        count += helper(arr,idx+1,target+arr[idx]);
        return count;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums,0,target);
    }
}