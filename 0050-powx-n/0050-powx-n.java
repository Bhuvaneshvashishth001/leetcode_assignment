class Solution {
    public double sol(double x,long n){
        if(n ==0){
            return 1.0;
        }
        double half = sol(x,n/2);
        double ans = half*half;
        if(n%2 !=0){
            ans *=x;
        }
        return ans;
    }
    public double myPow(double x, int n) {
        if(x == 0.0){
            return 0.0;
        }
        long num = n;
        if(num<0){
            x= 1/x;
            num = -num;
        }
        return sol(x,num);
    }
}