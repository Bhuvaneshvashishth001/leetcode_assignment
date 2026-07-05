class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int tank = 0;
        int start = 0;
        int ans = -1;
        int totalgas = 0;
        int totalcost = 0;
        for(int i=0 ; i<n ;i++){
            totalgas += gas[i];
            totalcost += cost[i];
        }
        if(totalgas < totalcost){
            return -1;
        }
        for(int i = 0 ;i < 2*n ;i++){
            tank += (gas[i % n] - cost[i % n]);
            if(tank < 0 ){
                tank = 0;
                start = i+1;
            } 
            if(i-start+1 == n ){
                ans = start;
                return ans;
            }
        }
        return -1;
    }
}