class Solution {
    public int numWays(String s) {
        int n = s.length();
        int pre[] = new int[n];
        pre[0] = s.charAt(0)-'0';
        for(int i=1;i<n;i++){
            pre[i] = s.charAt(i)-'0'+pre[i-1];
        }
        if(pre[n-1] ==0){
            long ways = (long)(n-1)*(n-2)/2;
            return (int)(ways%1000000007);
        }
        if(pre[n-1]%3 != 0){
            return 0;
        }
        int ones = pre[n-1]/3;
        int s1 = 0;
        int s2 = 0;
        for(int i=0;i<n;i++){
            if(pre[i] == ones){
                s1++;
            }
            if(pre[i] == 2*ones){
                s2++;
            }
        }
        return (int)((long)s1 * s2 % 1000000007);
    }
}