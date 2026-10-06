class Solution {
    public long subArrayRanges(int[] arr) {
        int n = arr.length;
        int pse[] = new int[n];
        int nse[] = new int[n];
        int pge[] = new int[n];
        int nge[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                pse[i] =-1;
            }
            else{
                pse[i] = stack.peek();
            }
            stack.push(i);
        } 
        stack.clear();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nse[i] = n;
            }
            else{
                nse[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]<arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                pge[i] =-1;
            }
            else{
                pge[i] = stack.peek();
            }
            stack.push(i);
        } 
        stack.clear();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]<= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nge[i] = n;
            }
            else{
                nge[i] = stack.peek();
            }
            stack.push(i);
        }
        long maxSum = 0;
        long minSum = 0;
        for(int i=0;i<n;i++){
            long l = i-pse[i];
            long r = nse[i]-i;
            minSum = minSum+(arr[i]*l*r);

            long l1 = i-pge[i];
            long r1 = nge[i]-i;
            maxSum = maxSum+(arr[i]*l1*r1);
        }
        return maxSum-minSum;
    }
}