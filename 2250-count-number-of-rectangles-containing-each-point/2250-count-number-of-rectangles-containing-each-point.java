class Solution{
    public static int bs(ArrayList<Integer> a,int x){
        int l=0,r=a.size();
        while(l<r){
            int m=(l+r)/2;
            if(a.get(m)>=x)r=m;
            else l=m+1;
        }
        return l;
    }
    public int[] countRectangles(int[][] rect,int[][] p){
        ArrayList<Integer>[] h=new ArrayList[101];
        for(int i=0;i<=100;i++){
            h[i]=new ArrayList<>();
        }
        for(int[] r:rect){
            h[r[1]].add(r[0]);
        }
        for(int i=1;i<=100;i++){
            Collections.sort(h[i]);
        }
        int[] ans=new int[p.length];
        for(int i=0;i<p.length;i++){
            int x=p[i][0],y=p[i][1];
            int cnt=0;
            for(int j=y;j<=100;j++){
                ArrayList<Integer> list=h[j];
                if(list.size()==0)continue;
                int idx=bs(list,x);
                cnt+=list.size()-idx;
            }
            ans[i]=cnt;
        }
        return ans;
    }
}
