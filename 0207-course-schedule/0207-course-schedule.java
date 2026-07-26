class Solution {
    public boolean cycle(int node,ArrayList<ArrayList<Integer>> adj,int vis[]){
        vis[node] = 1;
        for(int it:adj.get(node)){
            if(vis[it] == 0){
                if(cycle(it,adj,vis)){
                    return true;
                }
            }
            else if(vis[it] == 1){
                return true;
            }
        }
        vis[node] = 2;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[] : graph){
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u);
        }
        int vis[] = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(vis[i] == 0){
                if(cycle(i,adj,vis)){
                    return false;
                }
            }
        }
        return true;
    }
}