class Solution {
    public int countPermutations(int[] comp) {
        int n = comp.length;
        int small = comp[0];
        for(int i=1;i<n;i++){
            if(comp[i]<=small){
                return 0;
            }
        }
        long fact = 1;
        for(int i=1;i<n;i++){
            fact = (fact*i)%1000000007;;
        }
        return (int)fact;
    }
}