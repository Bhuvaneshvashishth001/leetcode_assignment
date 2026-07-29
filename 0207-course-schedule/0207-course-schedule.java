class Solution {
    public boolean canFinish(int n, int[][] pre) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int schedule[] = new int[n];
        for(int edge[] : pre){
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u);
            schedule[u]++;
        }
        Queue<Integer> queue= new LinkedList<>();
        for(int i=0;i<n;i++){
            if(schedule[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int it:adj.get(node)){
                schedule[it]--;
                if(schedule[it] == 0){
                    queue.add(it);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(schedule[i] != 0){
                return false;
            }
        }
        return true;
    }
}