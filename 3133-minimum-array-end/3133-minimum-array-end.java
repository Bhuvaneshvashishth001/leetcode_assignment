class Solution {
    public long minEnd(int n,int x){
        long ans = x;
        long add = n - 1;
        int bit = 0;
        while(add > 0){
            if((ans & (1L << bit)) == 0){
                if((add & 1) == 1){
                    ans |= (1L << bit);
                }
                add >>= 1;
            }
            bit++;
        }
        return ans;
    }
}
