class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int i = 0;
        ArrayList<int[]> ans = new ArrayList<>();
        while(i<n && newInterval[0] > intervals[i][1]){
            ans.add(new int[]{intervals[i][0],intervals[i][1]});
            i++;
        }
        while(i<n && newInterval[1]>=intervals[i][0]){
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        ans.add(new int[]{newInterval[0],newInterval[1]});
        while(i<n){
            ans.add(new int[]{intervals[i][0],intervals[i][1]});
            i++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}