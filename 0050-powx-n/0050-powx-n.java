class Solution {
    public double helper(double x,int n){
        if(n==0){
            return 1.0;
        }
        double half = helper(x,n/2);
        double ans =  half*half;
        if(n%2 != 0){
            ans = ans*x;
        }
        return ans;
    }
    public double myPow(double x, int n) {
        if(x == 0.0){
            return 0.0;
        }
        if(n== 0){
            return 1.0;
        }
        int num = n;
        if(num < 0){
            x = 1/x;
            num = -num;
        }
        return helper(x,num);
    }
}