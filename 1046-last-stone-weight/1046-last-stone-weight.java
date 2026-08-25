class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        for(int i:stones){
            queue.add(i);
        }
        while(queue.size()>1){
            int first = queue.poll();
            int second = queue.poll();
            queue.add(first-second);
        }
        return queue.poll();
    }
}