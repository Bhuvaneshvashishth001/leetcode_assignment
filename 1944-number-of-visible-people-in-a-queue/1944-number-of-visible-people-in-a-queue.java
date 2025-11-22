class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int arr[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;++i){
            while(!stack.isEmpty() && heights[stack.peek()]<=heights[i]){
                arr[stack.pop()]++;
            }
            if(!stack.isEmpty()){
                arr[stack.peek()]++;
            }
            stack.add(i);
        }
        return arr;
    }
}