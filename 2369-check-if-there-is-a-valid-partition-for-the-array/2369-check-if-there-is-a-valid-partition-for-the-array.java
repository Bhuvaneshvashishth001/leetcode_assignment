class Solution {
    public boolean helper(int arr[],int idx,Boolean dp[]){
        if(idx == arr.length){
            return true;
        }
        if(dp[idx] != null){
            return dp[idx];
        }
        if(idx+1 < arr.length && arr[idx] == arr[idx+1]){
            if(helper(arr,idx+2,dp)){
                return dp[idx] =  true;
            }
        }
        if(idx+2 <arr.length && arr[idx] == arr[idx+1] && arr[idx+1] == arr[idx+2]){
            if(helper(arr,idx+3,dp)){
                return dp[idx] = true;
            }
        }
        if(idx+2 < arr.length && arr[idx]+1 == arr[idx+1] && arr[idx+1]+1 == arr[idx+2]){
            if(helper(arr,idx+3,dp)){
                return dp[idx] = true;
            }
        }
        return dp[idx] = false;
    }
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        Boolean dp[] = new Boolean[n];
         return helper(nums,0,dp);  
    }
}