class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int indegree[] = new int[n];
        for(int edge[]:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0 ;i<n;i++){
            if(indegree[i] ==0){
                queue.add(i);
            }
        }
        List<TreeSet<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new TreeSet<>());
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int nei:adj.get(node)){
                list.get(nei).add(node);
                list.get(nei).addAll(list.get(node));
                indegree[nei]--;
                if(indegree[nei] ==0){
                    queue.add(nei);
                }
            }
        }
        List<List<Integer>> list1 = new ArrayList<>();
        for(int i=0;i<n;i++){
            list1.add(new ArrayList<>(list.get(i)));
        }
        return list1;
    }
}