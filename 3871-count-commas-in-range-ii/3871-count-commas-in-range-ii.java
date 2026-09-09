class Solution {
    public long countCommas(long n) {
        long val = n;
        long ans = 0;
        long start = 1000;
        int commas = 1;
        while(start <= val) {
            long end = Math.min(val, start * 1000 - 1);
            ans += (end-start+1) * commas;   
            start *= 1000;
            commas++;
        }
        return ans;
    }
}