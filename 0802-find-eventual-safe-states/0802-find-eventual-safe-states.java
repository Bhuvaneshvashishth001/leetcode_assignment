class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V= graph.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        int outdegree[] = new int[V];
        int u=0;
        for(int edge[]:graph){
            for(int i=0;i<edge.length;i++){
                adj.get(edge[i]).add(u);
                outdegree[u]++;
            }
            u++;
        }
        Queue<Integer> queue = new LinkedList<>();
            List<Integer>list = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(outdegree[i] ==0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            list.add(node);
            for(int ele:adj.get(node)){
                outdegree[ele]--;
                if(outdegree[ele] ==0){
                    queue.add(ele);
                }
            }
        }
        Collections.sort(list);
        return list;
    }
}