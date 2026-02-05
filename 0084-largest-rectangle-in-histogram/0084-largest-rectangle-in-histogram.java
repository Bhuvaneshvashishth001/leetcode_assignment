class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int pse[] = new int[n];
        int nse[] = new int[n];
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
                nse[i] =n;
            }
            else{
                nse[i] = stack.peek();
            }
            stack.push(i);
        }
        int max= 0;
        for(int i=0;i<n;i++){
            int total =0;
            int l = pse[i];
            int r = nse[i];
            total = (r-(l+1))*arr[i];
            max = Math.max(max,total);
        }
        return max;
    }
}