class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(a,b)->{
            return a[0]-b[0];
        });
        List<int[]> ans = new ArrayList<>();
        int i=0;
        int last = intervals[i][1];
        int j =1;
        while(j<n){
            if(last >= intervals[j][0]){
                last = Math.max(last,intervals[j][1]);
            }
            else{
                ans.add(new int[]{intervals[i][0],last});
                i = j; 
                last = intervals[i][1];
            }
            j++;
        }
        ans.add(new int[]{intervals[i][0],last});
        return ans.toArray(new int[ans.size()][]);
    }
}