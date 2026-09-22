class Solution {
    public boolean canJump(int[] arr) {
        int range =0;
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(i>range){
                return false;
            }
            if(i+arr[i] >= range){
                range = i+arr[i];
                if(range >= n-1){
                    return true;
                }
            }
        }
        return true;
    }
}