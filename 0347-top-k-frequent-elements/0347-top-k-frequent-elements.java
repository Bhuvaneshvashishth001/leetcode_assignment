class Solution {
    class Pair{
        int ele;
        int freq;
        public Pair(int ele,int freq){
            this.ele = ele;
            this.freq = freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b)->a.freq-b.freq);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            queue.add(new Pair(entry.getKey(),entry.getValue()));
            if(queue.size()>k){
                queue.poll();
            }
        }
        int ans[] = new int[k];
        int i = 0;
        if(queue.size()<k){
            return new int[]{-1};
        }
        while(k!=0 && !queue.isEmpty()){
            ans[i] = queue.poll().ele;
            i++;
            k--;
        }
        return ans;
    }
}