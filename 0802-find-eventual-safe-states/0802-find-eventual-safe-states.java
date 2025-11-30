class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int state[] = new int[n];
        int marked[] = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(marked[i] ==1){
                list.add(i);
            }
            if(marked[i] ==0 && dfs(i,graph,state,marked)){
                list.add(i);
            }
        }
        return list;
    }
    public static boolean dfs(int node,int graph[][],int state[],int marked[]){
        if(state[node]>0){
            return state[node] ==2;
        }
        state[node] =1;
        for(int ele : graph[node]){
            if(!dfs(ele,graph,state,marked)){
                return false;
            }
        }
        state[node] =2;
        marked[node]=1;
        return true;
    }
}