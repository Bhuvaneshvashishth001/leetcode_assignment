class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n-k+1];
        Deque<Integer> queue = new ArrayDeque<>();
        int j=0;
        for(int i=0;i<k;i++){
            if(!queue.isEmpty()){
                if(nums[i] == nums[queue.peekLast()]+1){
                    queue.add(i);
                }
                else{
                    while(!queue.isEmpty() && nums[queue.peekLast()]+1!=nums[i]){
                        queue.pollLast();
                    }
                    queue.add(i);
                }
            }
            else{
                queue.add(i);
            }
        }
        if(queue.size() == k){
            ans[j++] = nums[queue.peekLast()];
        }
        else{
            ans[j++] =-1;
        }
        for(int i=k;i<n;i++){
            if(!queue.isEmpty() && queue.peekFirst()<=i-k){
                queue.poll();
            }
            if(!queue.isEmpty()){
                if(nums[i] == nums[queue.peekLast()]+1){
                    queue.add(i);
                }
                else{
                    while(!queue.isEmpty() && nums[queue.peekLast()]+1!=nums[i]){
                        queue.pollLast();
                    }
                    queue.add(i);
                }   
            }
            else{
                queue.add(i);
            }
            if(queue.size() == k){
                ans[j++] = nums[queue.peekLast()];
            }
            else{
                ans[j++] = -1;
            }
        }
        return ans;
    }
}