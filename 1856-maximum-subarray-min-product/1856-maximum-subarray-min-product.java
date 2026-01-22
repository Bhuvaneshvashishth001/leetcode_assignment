class Solution {
    public int maxSumMinProduct(int[] arr) {
        int n = arr.length;
        int pse[] = new int[n];
        int nse[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        int mod = 1_000_000_007;
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                pse[i] = -1;
            }
            else{
                pse[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nse[i] =n;
            }
            else{
                nse[i] =stack.peek();
            }
            stack.push(i);
        }
        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + arr[i];
        }
        long max = 0;
        for (int i=0;i<n;i++){
            int left = pse[i]+1;
            int right = nse[i]-1;
            long sum = pre[right + 1] - pre[left];
            long product = sum*arr[i];
            max = Math.max(max,product);
        }
        return (int)(max%mod);
    }
}