class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int m = baskets.length;
        int fill[] = new int[m];
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(baskets[j]>=fruits[i] && fill[j] != 1){
                    fill[j] =1;
                    break;
                }
            }
        }
        for(int i=0;i<m;i++){
            if(fill[i] != 1){
                count++;
            }
        }
        return count;
    }
}