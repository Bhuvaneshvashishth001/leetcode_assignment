class Solution{
    public long makeSubKSumEqual(int[] a,int k){
        int n=a.length;
        int g=gcd(n,k);
        long res=0;
        for(int s=0;s<g;s++){
            ArrayList<Integer> v=new ArrayList<>();
            for(int i=s;i<n;i+=g){
                v.add(a[i]);
            }
            Collections.sort(v);
            int m=v.get(v.size()/2);
            for(int val:v){
                res+=Math.abs(val-m);
            }
        }
        return res;
    }
    int gcd(int x,int y){
        return y==0?x:gcd(y,x%y);
    }
}
