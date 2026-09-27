class Solution {
    public boolean isPossible(int piles[],int h,int speed){
        long totalhr = 0;
        for(int banana:piles){
            totalhr += (int)Math.ceil((double)banana/speed);
        }
        if(totalhr <= h){
            return true;
        }
        return false;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = 0;
        for(int banana : piles){
            max  = Math.max(max,banana);
        }
        int start = 1;
        int end = max;
        int speed = max;
        while(start <= end){
            int mid = start+(end-start)/2;
            if(isPossible(piles,h,mid)){
                speed = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return speed;
    }
}