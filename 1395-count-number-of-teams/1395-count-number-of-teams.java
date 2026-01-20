class Solution {
    public int numTeams(int[] arr) {
        int n = arr.length;
        int max[] = new int[n];
        int min[] = new int[n];
        for(int i=0;i<n;i++){
            int gr = 0;
            int sr = 0;
            for(int j=i+1;j<n;j++){
                if(arr[i]>arr[j]){
                    sr++;
                }
                if(arr[i]<arr[j]){
                    gr++;
                }
            }
            max[i] = gr;
            min[i] = sr;
        }
        int ans =0;
        for(int i=0;i<n;i++){
            int gr = 0;
            int sr = 0;
            for(int j=0;j<i;j++){
                if(arr[i]<arr[j]){
                    gr++;
                }
                if(arr[i]>arr[j]){
                    sr++;
                }
            }
            ans += max[i]*sr;
            ans += min[i]*gr;
        }
        return ans;
    }
}