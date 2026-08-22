class Solution {
    public boolean checkDivisibility(int n) {
        int add = 0;
        int pro = 1;
        int temp = n;
        while(temp > 0){
            int rem = temp%10;
            add += rem;
            pro *= rem;
            temp/=10;
        }
        return (n%(add+pro) == 0)?true:false;
    }
}