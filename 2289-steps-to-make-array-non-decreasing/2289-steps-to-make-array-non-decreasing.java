class Solution {
    public int totalSteps(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(n-1);
        int max = 0;
        int j=n-2;
        int rem[] = new int[n];
        while(!stack.isEmpty() && j>=0){
            int count = 0;
            while(!stack.isEmpty() && nums[stack.peek()]<nums[j]){
                count = Math.max(count+1,rem[stack.peek()]);
                stack.pop();
            }
            rem[j] =count;
            stack.push(j);
            max = Math.max(max,count);
            j--;
        }
        return max;
    }
}