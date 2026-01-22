class Solution {
    public int maximizeWin(int[] arr, int k) {
        int n = arr.length;
        int len[] = new int[n];
        int j=0;
        for(int i=0; i<n;i++){
            while(arr[i] > arr[j]+k){
                j++;
            }
            len[i] = i-j+1;
        }
        int pre[] = new int[n];
        pre[0] = len[0];
        for(int i=1;i<n;i++){
            pre[i] = Math.max(len[i],pre[i-1]);
        }
        int j1 =0;
        int max = 0;
        for(int i=0;i<n;i++){
            while(arr[i] > arr[j1]+k){
                j1++;
            }
            int win = i-j1+1;
            int prev = (j1>0) ? pre[j1-1]:0;
            max = Math.max(max,(win+prev));
        }
        return max;
    }
}