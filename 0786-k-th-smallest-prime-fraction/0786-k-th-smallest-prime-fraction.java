class Solution {
    class Tuple{
        int a;
        int b;
        double fr;
        public Tuple(int a,int b,double fr){
            this.a = a;
            this.b = b;
            this.fr = fr;
        }
    }
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<Tuple> queue = new PriorityQueue<>((a,b)->Double.compare(a.fr, b.fr));
        for(int i=0;i<n;i++){
            for(int j=n-1;j>i;j--){
                queue.add(new Tuple(arr[i],arr[j],(double)arr[i]/arr[j]));
            }
        }
        while(k-->1){
            queue.poll();
        }
        Tuple t = queue.poll();
        int a1 = t.a;
        int b1 = t.b;
        return new int[]{a1,b1};
    }
}