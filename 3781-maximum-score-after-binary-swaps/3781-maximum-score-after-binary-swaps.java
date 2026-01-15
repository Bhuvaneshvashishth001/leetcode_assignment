class Solution {
    public long maximumScore(int[] nums, String s) {
        int n = nums.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)-> b-a);
        long sum =0;
        for(int i=0;i<n;i++){
            if(s.charAt(i) =='0'){
                queue.add(nums[i]);
            }
            else{
                if(!queue.isEmpty()){
                    if(queue.peek() >nums[i]){
                        sum += queue.poll();
                        queue.add(nums[i]);
                    }
                    else{
                        sum+= nums[i];
                    }
                }
                else{
                    sum += nums[i];
                }
            }
        }
        return sum;
    }
}