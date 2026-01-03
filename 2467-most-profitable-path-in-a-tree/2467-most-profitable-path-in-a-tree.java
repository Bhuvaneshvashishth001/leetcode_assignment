class Solution{
    public boolean dfsBob(int node,int parent,int bob,int[] bobTime,ArrayList<ArrayList<Integer>> adj){
        if(node==bob){
            bobTime[node]=0;
            return true;
        }
        for(int nei:adj.get(node)){
            if(nei==parent)continue;
            if(dfsBob(nei,node,bob,bobTime,adj)){
                bobTime[node]=bobTime[nei]+1;
                return true;
            }
        }
        return false;
    }
    public void dfsAlice(int node,int parent,int time,int profit,int[] bobTime,int[] amount,ArrayList<ArrayList<Integer>> adj,int ans[]){
        if(time<bobTime[node])profit+=amount[node];
        else if(time==bobTime[node])profit+=amount[node]/2;
        boolean isLeaf=true;
        for(int nei:adj.get(node)){
            if(nei==parent)continue;
            isLeaf=false;
            dfsAlice(nei,node,time+1,profit,bobTime,amount,adj,ans);
        }
        if(isLeaf)ans[0]=Math.max(ans[0],profit);
    }
    public int mostProfitablePath(int[][] edges,int bob,int[] amount){
        int n=amount.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int[] e:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int[] bobTime=new int[n];
        Arrays.fill(bobTime,Integer.MAX_VALUE);
        int[] ans=new int[]{Integer.MIN_VALUE};
        dfsBob(0,-1,bob,bobTime,adj);
        dfsAlice(0,-1,0,0,bobTime,amount,adj,ans);
        return ans[0];
    }
}
