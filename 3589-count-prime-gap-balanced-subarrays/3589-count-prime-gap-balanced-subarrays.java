class Solution {
    int prime[] = new int[50001];
    public void sieve(){
        int  n = prime.length;
        prime[0] =1;
        prime[1] =1;
        for(int i=2;i*i<n;i++){
            if(prime[i] ==0){
                for(int j=i*i;j<n;j+=i){
                    prime[j] =1;
                }
            }
        }
    }
    public int primeSubarray(int[] nums, int k) {
        sieve();
        int m = nums.length;
        PriorityQueue<int[]>min = new PriorityQueue<>((a,b)->a[0]-b[0]);
        PriorityQueue<int[]>max = new PriorityQueue<>((a,b)->b[0]-a[0]);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int i=0;
        int ans =0;
        for(int j=0;j<m;j++){
            if(prime[nums[j]] ==0){
                min.add(new int[]{nums[j],j});
                max.add(new int[]{nums[j],j});
                queue.addLast(j);
            }
            while(queue.size()>=2 && max.peek()[0]-min.peek()[0] >k){
                if(!queue.isEmpty() && queue.peekFirst() ==i){
                    queue.pollFirst();
                }
                i++;
                while(!min.isEmpty() && min.peek()[1]<i){
                    min.poll();
                }
                while(!max.isEmpty() && max.peek()[1]<i){
                    max.poll();
                }
            }
            if(queue.size()>=2){
                int second = queue.peekLast();
                queue.pollLast();
                int first = queue.peekLast();
                queue.addLast(second);
                ans += first-i+1;
            }
        }
        return ans;
    }
}