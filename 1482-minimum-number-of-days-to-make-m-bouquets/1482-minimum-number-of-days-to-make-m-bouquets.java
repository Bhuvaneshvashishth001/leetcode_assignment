class Solution {
    public boolean isPossible(int num,int arr[] ,int k,int m){
        int bouquet = 0;
        int bloom = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] <= num){
                bloom++;
            }
            else{
                bouquet += bloom/k;
                bloom = 0; 
            }
        }
        bouquet += bloom/k;
        return bouquet>=m;
    }
    public int minDays(int[] arr, int m, int k) {
        int n = arr.length;
        if(n < m*k){
            return -1;
        }
        int max = 0;
        for(int num : arr){
            max = Math.max(max,num);
        }
        int start = 1;
        int end = max;
        int ans = -1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(isPossible(mid,arr,k,m)){
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