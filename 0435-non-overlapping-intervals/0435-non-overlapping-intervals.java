class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int start = intervals[0][1];
        int count = 0;
        for(int i=0;i<n-1;i++){
            if(start <= intervals[i+1][1] && intervals[i+1][0]<start){
                count ++;
            }
            else{
                start =intervals[i+1][1];
            }
        }
        return count;
    }
}