class Solution {
    public int smallestNumber(int n, int t) {
        if(n%10 == 0){
            return n;
        }
        for(int i=n;i<n+10;i++){
            int num = 1;
            int k = i;
            while(k>0){
                int d = k%10;
                num = num*d;
                k/=10;
            }
            if(num%t == 0 ){
                return i;
            }
        }
        return -1;
    }
}