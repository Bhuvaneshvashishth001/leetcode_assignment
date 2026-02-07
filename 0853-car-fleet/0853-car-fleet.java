class Solution {
    public int carFleet(int target, int[] pos, int[] speed) {
        int n = pos.length;
        int car[][] = new int[n][2];
        for(int i=0;i<n;i++){
            car[i][0] = pos[i];
            car[i][1] = speed[i];
        }
        Arrays.sort(car,(a,b)->{
            return b[0]-a[0];
        });
        Stack<Double> stack = new Stack<>();
        for(int i=0;i<n;i++){
            int p= car[i][0];
            int s= car[i][1];
            double t= (double)(target-p)/s;
            if(stack.isEmpty() || t>stack.peek()){
                stack.push(t);
            }
        }
        return stack.size();
    }
}