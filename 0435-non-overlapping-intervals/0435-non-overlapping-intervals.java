class Solution {
    public int eraseOverlapIntervals(int[][] arr) {
        int n = arr.length;
        Arrays.sort(arr,(a,b)->a[1]-b[1]);
        int start = arr[0][1];
        int count =0;
        for(int i=0;i<n-1;i++){
            if(start<=arr[i+1][1] && start>arr[i+1][0]){
                count++;
            }
            else{
                start = arr[i+1][1];
            }
        }
        return count;
    }
}