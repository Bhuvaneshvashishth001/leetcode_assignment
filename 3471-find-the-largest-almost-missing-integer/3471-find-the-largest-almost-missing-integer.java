class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int arr[] = new int[51];
        for(int i=0;i<n;i++){
            arr[nums[i]]++;
        }
        int max = -1;
        if(k == 1){
            for(int i=0;i<n;i++){
                if(arr[nums[i]] == 1 && nums[i]>max){
                    max = nums[i];
                }
            }
        }
        else if(k==n){
            for(int i=0;i<n;i++){
                max = Math.max(max,nums[i]);
            }
        }
        else{
            if(arr[nums[0]] == 1 && nums[0]>max){
                max = nums[0];
            }
            if(arr[nums[n-1]] == 1 && nums[n-1]>max){
                max = nums[n-1];
            }
        }
        return max;
    }
}