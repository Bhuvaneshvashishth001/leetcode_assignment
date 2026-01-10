class Solution {
    public boolean isPossible(int arr[],int mid,int m,int k){
        int bouquet = 0;
        int flower = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=mid){
                flower++;
            }
            else{
                bouquet += flower/k;
                flower =0;
            }
        }
        bouquet += flower/k;
        return bouquet>=m;
    }
    public int minDays(int[] bloom, int m, int k) {
        int low =1;
        int high = 0;
        int n = bloom.length;
        for(int i=0;i<n;i++){
            high = Math.max(high,bloom[i]);
        }
        if(m*k >n){
            return -1;
        }
        int ans =-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(isPossible(bloom,mid,m,k)){
                ans =mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
}