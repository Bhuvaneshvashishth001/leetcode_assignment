class Solution {
    int mod = 1_000_000_007;
    public long sol(int x,int n){
        if(n==0){
            return 1;
        }
        long half = sol(x,n/2);
        long ans = (half*half)%mod;
        if(n%2 != 0){
            ans = (ans*x)%mod;
        }
        return ans;
    }
    public int monkeyMove(int n) {
        long total = sol(2,n);
        return (int)((total-2+mod) % mod);
    }
}