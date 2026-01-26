class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[2] != b[2] ?a[2]-b[2] : a[0]-b[0]);
        for(int i=1;i<n;i++){
            int a = arr[i-1];
            int b = arr[i];
            int c = Math.abs(b-a);
            queue.add(new int[]{a,b,c});
        }
        int min = queue.peek()[2];
        List<List<Integer>> list = new ArrayList<>();
        while(!queue.isEmpty()){
            if(queue.peek()[2] == min){
                ArrayList<Integer> list1 = new ArrayList<>();
                list1.add(queue.peek()[0]);
                list1.add(queue.peek()[1]);
                list.add(list1);
                queue.poll();
            }
            else{
                break;
            }
        }
        return list;
    }
}