class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int pge[] = new int[n];
        int nge[] = new int[n];
        pge[0] = 0;
        int max = arr[0];
        for(int i=1;i<n;i++){
            if(max > arr[i]){
                pge[i] = max;
            }
            else{
                max =arr[i];
                pge[i] = 0;
            }
        }
        nge[n-1] = 0;
        int max1 = arr[n-1];
        for(int i=n-2;i>=0;i--){
            if(max1 > arr[i]){
                nge[i] = max1;
            }
            else{
                max1 = arr[i];
                nge[i] = 0;
            }
        }
        int total = 0;
        for(int i =0;i<n;i++){
            int min = Math.min(pge[i],nge[i]);
            if(min>arr[i]){
                total += (min-arr[i]);
            }
        }
        return total;
    }
}