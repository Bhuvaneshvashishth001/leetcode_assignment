class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(a,b)->{
            return a[1]-b[1];
        });
        int i = 0;
        int last = intervals[i][1];
        int j=1;
        int count = 0;
        while(j<n){
            if(intervals[j][0] < last){
                count++;
            }
            else{
                last = intervals[j][1];
            }
            j++;
        } 
        return count;
    }
}