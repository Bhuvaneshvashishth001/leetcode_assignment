class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n-k+1];
        int max = Integer.MIN_VALUE;
        int idx = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(!queue.isEmpty() && queue.peekFirst() <= i-k){
                queue.pollFirst();
            }
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            queue.addLast(i);
            if(i>= k-1){
                ans[idx] = nums[queue.peekFirst()];
                idx++;
            }
        }
        return ans;
    }
}