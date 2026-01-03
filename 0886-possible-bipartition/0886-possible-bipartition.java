class Solution {
    public static boolean bfs(int i,Set<Integer> set1,Set<Integer> set2,ArrayList<ArrayList<Integer>> adj,int visited[]){
        visited[i] =1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        set1.add(i);
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int it:adj.get(node)){
                if(visited[it]!=1 && set1.contains(node)){
                    visited[it] =1;
                    set2.add(it);
                    queue.add(it);
                }
                else if(visited[it]!=1 && set2.contains(node)){
                    visited[it] =1; 
                    set1.add(it);
                    queue.add(it);
                }
                else if((set1.contains(node) && set1.contains(it)) || set2.contains(node) && set2.contains(it)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[]:graph){
            int u =edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        int visited[] = new int[n+1];
        for(int i=1;i<n+1;i++){
            if(visited[i]!=1){
                if(!bfs(i,set1,set2,adj,visited)){
                    return false;
                }
            }
        }
        return true;
    }
}