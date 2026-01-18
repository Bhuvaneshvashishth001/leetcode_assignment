class Solution {
    public long maxTotal(int[] value, int[] limit) {
        int n = value.length;
        int arr[][] = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0] = limit[i];
            arr[i][1] = value[i];
        }
        Arrays.sort(arr,(a,b)->{
            if(a[0]!=b[0]){
                return a[0]-b[0];
            }
            return b[1]-a[1];
        });
        long total = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int edge[]:arr){
            int l = edge[0];
            int ele = edge[1];
            if(queue.size() == l){
                continue;
            }
            while(!queue.isEmpty() && queue.peek()[0]<= queue.size()){
                queue.poll();
            }
            if(queue.size()<l){
                queue.add(new int[]{l,ele});
                total+=ele;
            }
        }
        return total;
    }
}