class Solution {
    public int minimumBuckets(String hamsters) {
        int n = hamsters.length();
        char[] arr = hamsters.toCharArray();
        int buckets = 0;
        for(int i =0; i < n; i++){
            if(arr[i] == 'H'){
                if((i-1 >= 0 && arr[i-1] == 'B') || (i+1 < n && arr[i+1] == 'B')){
                    continue;
                }
                if (i+1 < n && arr[i +1] == '.'){
                    buckets++;
                    arr[i+1] = 'B';
                }
                else if(i-1 >= 0 && arr[i-1] == '.'){
                    buckets++;
                    arr[i-1] = 'B';
                }
                else{
                    return -1;
                }
            }
        }
        return buckets;
    }
}
