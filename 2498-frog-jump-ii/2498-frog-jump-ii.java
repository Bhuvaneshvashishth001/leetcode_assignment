class Solution {
    public int maxJump(int[] stones) {
        int minCost = Integer.MIN_VALUE;
        int n = stones.length;
        if(n == 2){
            return stones[1] - stones[0];
        }
        for(int i=0;i<n-2;i++){
            int jump = stones[i+2]-stones[i];
            minCost = Math.max(jump,minCost);
        }
        return minCost;
    }
}