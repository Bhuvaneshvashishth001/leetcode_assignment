class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int tank = 0;
        int spend = 0;
        int j = 0;
        for(int i=0;i<2*n && j<n;i++){
            tank += gas[i%n];
            spend = cost[i%n];
            if(tank >= 0 && (i%n == j && i>j)){
                return j;
            }
            else if(tank-spend >= 0){
                tank = tank-spend;
            }
            else{
                j=i+1;
                tank = 0;
                spend = 0;
            }
        }
        return -1;
    }
}