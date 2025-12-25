class Solution{
    public static int rev(int x){
        int r=0;
        while(x>0){
            r=r*10+x%10;
            x/=10;
        }
        return r;
    }
    public int countNicePairs(int[] nums){
        int mod=1000000007;
        HashMap<Integer,Long> map=new HashMap<>();
        long res=0;
        for(int x:nums){
            int v=x-rev(x);
            long c=map.getOrDefault(v,0L);
            res=(res+c)%mod;
            map.put(v,c+1);
        }
        return (int)res;
    }
}
