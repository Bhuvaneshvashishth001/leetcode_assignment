class Solution {
    public int find1(int nums[] , int target){
        int n = nums.length;
        int start = 0;
        int end = n-1;
        int ans = -1;
        while(start<= end){
            int mid = start+(end-start)/2;
            if(nums[mid] == target){
                end = mid-1;
                ans = mid;
            }
            else if(nums[mid] > target){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;
    }
    public int find2(int nums[],int target){
        int n = nums.length;
        int start = 0;
        int end = n-1;
        int ans = -1;
        while(start<= end){
            int mid = start+(end-start)/2;
            if(nums[mid] == target){
                start = mid+1;
                ans = mid;
            }
            else if(nums[mid] < target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int ans[] = new int[2];
        int first = find1(nums,target);
        int last = find2(nums,target);
        ans[0] = first;
        ans[1] = last;
        return ans;
    }
}