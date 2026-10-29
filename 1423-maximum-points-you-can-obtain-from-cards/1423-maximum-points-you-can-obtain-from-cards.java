class Solution {
    public int maxScore(int[] arr, int k) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int pre[] = new int[n];
        int suff[] = new int[n];
        pre[0] = arr[0];
        for(int i=1;i<n;i++){
            pre[i] = arr[i] + pre[i-1];
        }
        suff[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--){
            suff[i] = arr[i] + suff[i+1];
        }
        max = pre[k-1];
        int total = max;
        for(int i=k-2;i>=-1;i--){
            total = total-arr[i+1]+arr[(n-1)-((k-1)-(i+1))];
            max = Math.max(max,total);
        }
        return max;
    }
}