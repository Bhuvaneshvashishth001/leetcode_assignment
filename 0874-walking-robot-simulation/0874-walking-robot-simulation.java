class Solution {
    public int robotSim(int[] arr, int[][] ob) {
        int n = arr.length;
        HashSet<String> set = new HashSet<>();
        for(int edge[]:ob){
            int u = edge[0];
            int v = edge[1];
            set.add(u+","+v);
        }
        int ans = 0;
        int sr= 0;
        int sc= 0;
        int count = 0;
        for(int i=0;i<n;i++){
            if(arr[i] == -1){
                count++;
            }
            else if(arr[i] == -2){
                count--;
            }
            else{
                int steps = arr[i];
                while(steps-->0){
                    int dr = sr;
                    int dc = sc;
                    int dir = ((count%4)+4)%4;
                    if(dir == 0){
                        dc++;
                    }
                    else if(dir == 1){
                        dr++;
                    }
                    else if(dir == 2){
                        dc--;
                    }
                    else{
                        dr--;
                    }
                    if(set.contains(dr+","+dc)){
                        break;
                    }
                    sr = dr;
                    sc = dc;
                    ans = Math.max(ans,sr*sr+sc*sc);
                }
            }
        }
        return ans;
    }
}  