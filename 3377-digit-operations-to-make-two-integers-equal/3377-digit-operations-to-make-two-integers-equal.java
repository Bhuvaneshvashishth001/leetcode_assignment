class Solution {
    int arr[] = new int[10001];
    public void sieve(){
        arr[0] =1;
        arr[1] =1;
        for(int i=2;i*i<arr.length ;i++){
            if(arr[i] == 0){
                for(int j=i*i;j<arr.length;j+=i){
                    arr[j] =1;
                }
            }
        }
    }
    public int minOperations(int n, int m) {
        sieve();
        if(arr[m] ==0 || arr[n]==0){
            return -1;
        }
        if(n<10 && m<10){
            if(n<m){
                for(int i=n+1;i<m;i++){
                    if(arr[i] == 0){
                        return -1;
                    }
                }  
            }
            else{
                for(int i=m+1;i<n;i++){
                    if(arr[i] == 0){
                        return -1;
                    }  
                }
            } 
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[1]-b[1]);
        int spend[] = new int[10001];
        Arrays.fill(spend,Integer.MAX_VALUE);
        spend[n] = n;
        queue.add(new int[]{n,n});
        while(!queue.isEmpty()){
            int pair[] = queue.poll();
            int num = pair[0];
            int cost = pair[1];
            if(num == m){
                return cost;
            }
            if(cost>spend[num]){
                continue;
            }
            char digit[] = String.valueOf(num).toCharArray();
            for(int i=0;i<digit.length;i++){
                int d = (int)(digit[i]-'0');
                if(d<9){
                    digit[i] = (char)(d+1+'0');
                    int curr = Integer.valueOf(new String(digit));
                    if(arr[curr]!= 0 && curr+cost<spend[curr]){
                        spend[curr] = curr+cost;
                        queue.add(new int[]{curr,spend[curr]});
                    }
                    digit[i] = (char)(d+'0');
                }
                if(d>0){
                    digit[i] = (char)(d-1+'0');
                    int curr = Integer.valueOf(new String(digit));
                    if(arr[curr]!= 0 && curr+cost<spend[curr]){
                        spend[curr] = curr+cost;
                        queue.add(new int[]{curr,spend[curr]});
                    }
                    digit[i] = (char)(d+'0');
                }
            }
        }
        return  -1;
    }
}