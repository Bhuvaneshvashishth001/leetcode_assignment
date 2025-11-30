class Solution {
    public static boolean dfs(int node,ArrayList<ArrayList<Integer>> adj,int v,int memo[][]){
        if(memo[node][v] != -1){
            return memo[node][v]==1;
        }
        for(int ele:adj.get(node)){
            if(ele == v || dfs(ele,adj,v,memo)){
                memo[node][v]=1;  
                return true;
            }
        }
        memo[node][v]=0;
        return false;
    }
    public List<Boolean> checkIfPrerequisite(int Courses, int[][] pre, int[][] q) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<Courses;i++){
            adj.add(new ArrayList<>());
        }
        int indegree[] = new int[Courses];
        for(int edge[]:pre){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        ArrayList<Boolean> list = new ArrayList<>();
        int memo[][] = new int[Courses][Courses];
        for(int arr[]:memo){
            Arrays.fill(arr,-1);
        }
        for(int edge[]:q){
            int u = edge[0];
            int v = edge[1];
            if(dfs(u,adj,v,memo)){
                list.add(true);
            }
            else{
                list.add(false);
            }
        }
        return list;
    }
}