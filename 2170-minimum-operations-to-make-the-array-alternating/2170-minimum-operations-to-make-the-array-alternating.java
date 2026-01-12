class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        if(n==1) return 0;
        HashMap<Integer,Integer> even = new HashMap<>();
        HashMap<Integer,Integer> odd = new HashMap<>();
        for(int i=0;i<n;i++){
            if(i%2==0){
                even.put(nums[i],even.getOrDefault(nums[i],0)+1);
            }else{
                odd.put(nums[i],odd.getOrDefault(nums[i],0)+1);
            }
        }
        int e[] = get(even);
        int o[] = get(odd);
        if(e[0]!=o[0]){
            return (n+1)/2 - e[1] + n/2 - o[1];
        }else{
            int a = (n+1)/2 - e[1] + n/2 - o[3];
            int b = (n+1)/2 - e[3] + n/2 - o[1];
            return Math.min(a,b);
        }
    }
    int[] get(HashMap<Integer,Integer> mp){
        int v1=-1,c1=0;
        int v2=-1,c2=0;
        for(int k:mp.keySet()){
            int c = mp.get(k);
            if(c>c1){
                c2=c1; v2=v1;
                c1=c;  v1=k;
            }else if(c>c2){
                c2=c; v2=k;
            }
        }
        return new int[]{v1,c1,v2,c2};
    }
}
