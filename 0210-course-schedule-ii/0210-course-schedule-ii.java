class Solution {
    public int[] findOrder(int n, int[][] pre) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int req[] = new int[n];
        for(int edge[] : pre){
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u);
            req[u]++;
        }
        int order[] = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        int j = 0;
        for(int i=0;i<n;i++){
            if(req[i] == 0){
                order[j++] = i;
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int course = queue.poll();
            for(int it:adj.get(course)){
                req[it]--;
                if(req[it] == 0){
                    order[j++] = it;
                    queue.add(it);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(req[i] != 0 ){
                return new int[]{};
            }
        }
        return order;
    }
}