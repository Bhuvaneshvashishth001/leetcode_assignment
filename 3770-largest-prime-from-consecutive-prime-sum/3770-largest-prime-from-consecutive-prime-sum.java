class Solution {
    int arr[] = new int[500001];
    public void sieve(){
        arr[0] =1;
        arr[1] =1;
        for(int i=2;i*i<arr.length;i++){
            if(arr[i] == 0){
                for(int j=i*i ;j<arr.length ;j+=i){
                    arr[j] =1;
                }
            }
        }
    }
    public int largestPrime(int n) {
        sieve();
        int ans = 0;
        int sum = 0;
        for(int i=2;i<=n;i++){
            if(arr[i] ==0){
                sum+=i;
                if(sum<=n && arr[sum] ==0){
                    ans = sum;
                }
                if(sum>n){
                    break;
                }
            }
        }
        return ans;
    }
}