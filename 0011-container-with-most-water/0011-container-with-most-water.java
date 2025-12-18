class Solution {
    public int maxArea(int[] arr) {
        int l = 0;
        int r = arr.length-1;
        int total = 0;
        while(l<r){
            if(arr[l]<=arr[r]){
               int T = arr[l]*(r-l);
               if(T>total){
                total = T;
               }
               l++;
            }
            else{
                int T = arr[r]*(r-l);
                if(T>total){
                    total=T;
                }
                r--;
            }
        }
        return total;
    }
}