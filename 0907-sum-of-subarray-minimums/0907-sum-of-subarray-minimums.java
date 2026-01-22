class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int pse[] = new int[n];
        int nse[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        int j=0;
        int mod = 1_000_000_007;
        while(j<n){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[j]){
                stack.pop();
            }
            if(stack.isEmpty()){
                pse[j] = -1;
            }
            else{
                pse[j] = stack.peek();
            }
            stack.push(j);
            j++;
        }
        stack.clear();
        int i=n-1;
        while(i>=0){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nse[i] = n;
            }
            else{
                nse[i] = stack.peek();
            }
            stack.push(i);
            i--;
        }
        long result = 0;
        for(int k=0;k<n;k++){
            long l = k-pse[k];
            long r = nse[k] -k;
            result = (result+arr[k]*l*r)%mod;
        }
        return (int)result;
    }
}