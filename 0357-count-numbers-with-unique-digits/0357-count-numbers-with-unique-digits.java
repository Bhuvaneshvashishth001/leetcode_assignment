class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        
        if(n==0) return 1;

        int unique=9;
        int fact=9;
        int ans=10;


        for(int i=2;i<=n && fact>0;i++){
           unique*=fact;
           ans+=unique;
           fact--;

        }

        return ans;
    }
}