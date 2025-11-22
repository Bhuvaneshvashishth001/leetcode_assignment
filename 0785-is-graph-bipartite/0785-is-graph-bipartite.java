class Solution {
    public static boolean dfs(int node,ArrayList<ArrayList<Integer>>adj,int visited[],int color){
        visited[node] = color;
        for(int ele : adj.get(node)){
            if(visited[ele] == -1){
                if(dfs(ele,adj,visited,1-color)){
                    return true;
                }
            }
            else{
                if(visited[ele] == visited[node]){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int j=0;
        for(int edge[] : graph){
            for(int ele:edge){
                adj.get(j).add(ele);
            }
            j++;
        }
        int color=1;
        int visited[] = new int[n];
        Arrays.fill(visited,-1);
        for(int i=0;i<n;i++){
            if(visited[i] == -1){
                if(dfs(i,adj,visited,color)){
                    return false;
                }
            }
        }
        return true;
    }
}