class Solution {
    public int maxScore(int[] arr, int k) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int total = 0;
        for(int i=0;i<k;i++){
            total += arr[i];
        }
        max = total;
        for(int i=k-2;i>=-1;i--){
            total = total-arr[i+1]+arr[(n-1)-((k-1)-(i+1))];
            max = Math.max(max,total);
        }
        return max;
    }
}