class Solution {
    class Pair{
        int par;
        ArrayList<Integer> child;
        public Pair(int par,ArrayList<Integer> child){
            this.par = par;
            this.child = child;
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        path.add(0);
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0,path));
        while(!queue.isEmpty()){
            Pair p =queue.poll();
            int v = p.par;
            ArrayList<Integer> list = p.child;
            if(v == n-1){
                ans.add(list);
                continue;
            }
            for(int it:adj.get(v)){
                ArrayList<Integer> newL = new ArrayList<>(list);
                newL.add(it);
                queue.add(new Pair(it,newL));
            }
        }
        return ans;
    }
}