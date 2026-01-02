class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0 ;i<n ;i++){
            adj.add(new ArrayList<>());
        }
        int indegree[] = new int[n];
        for(int edge[] : prerequisites){
            int u = edge[1];
            int v = edge[0];
            adj.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0 ;i<n ;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it] ==0){
                    queue.offer(it);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(indegree[i]!=0){
                return false;
            }
        }
        return true;
    }
}