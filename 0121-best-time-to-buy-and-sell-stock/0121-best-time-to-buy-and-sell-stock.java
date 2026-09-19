class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for(int i=0;i<n;i++){
            if(min>arr[i]){
                min = arr[i];
            }
            else{
                ans = Math.max(ans,arr[i]-min);
            }
        }
        return ans;
    }
}