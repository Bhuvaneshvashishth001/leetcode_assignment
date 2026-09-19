class Solution {
    public int maxArea(int[] arr) {
        int l = 0;
        int r = arr.length-1;
        int total = 0;
        while(l<r){
            if(arr[l] <= arr[r]){
                int t = arr[l]*(r-l);
                if(t > total){
                    total = t;
                }
                l++;
            }
            else{
                int t = arr[r]*(r-l);
                if(t>total){
                    total = t;                
                }
                r--;
            }
        }
        return total;
    }
}