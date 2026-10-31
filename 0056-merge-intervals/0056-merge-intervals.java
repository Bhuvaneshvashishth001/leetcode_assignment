class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(a,b)->{
            return a[0]-b[0];
        });
        ArrayList<int[]> ans = new ArrayList<>();
        int last[] = new int[2];
        int i=0;
        last[0] = intervals[i][0];
        last[1] = intervals[i][1];
        for(int j=1;j<n;j++){
            if(last[1]<intervals[j][0]){
                ans.add(new int[]{last[0],last[1]});
                last[0] = intervals[j][0];
                last[1] = intervals[j][1];
            }
            else if(last[1] >= intervals[j][1]){

            }
            else{
                last[1] = intervals[j][1];
            }
        }
        ans.add(last);
        return ans.toArray(new int[ans.size()][]);
    }
}