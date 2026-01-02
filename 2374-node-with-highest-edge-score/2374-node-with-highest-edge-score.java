class Solution {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long arr[] = new long[n];
        for(int i=0;i<n;i++){
            arr[edges[i]] += i; 
        }
        int ans = -1;
        long max= -1;
        for(int i=0;i<n;i++){
            if(arr[i]>max){
                ans=i;
                max=arr[i];
            }
        }
        return ans;
    }
}