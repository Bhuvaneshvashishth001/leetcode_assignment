class Solution {
    public static boolean isPossible(int time[],long spendTime,int total){
        long sum = 0;
        for(int i=0;i<time.length;i++){
            if(spendTime>=time[i]){
                sum += spendTime/(long)time[i];
            }
        }
        return sum>=total;
    }
    public long minimumTime(int[] time, int total) {
        int n = time.length;
        long min = Long.MAX_VALUE;
        for(int i=0;i<n;i++){
            min = Math.min(min,time[i]);
        }
        long low = 1;
        long high = (long)(total*min);
        long ans = high+1;
        while(low<=high){
            long mid = low+(high-low)/2;
            if(isPossible(time,mid,total)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
}