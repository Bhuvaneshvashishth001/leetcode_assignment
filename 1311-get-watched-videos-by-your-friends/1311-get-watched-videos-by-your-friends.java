class Solution {
    class Pair{
        int id;
        int lev;
        public Pair(int id,int lev){
            this.id = id;
            this.lev = lev;
        }
    }
    public List<String> watchedVideosByFriends(List<List<String>> watch, int[][] friends, int id, int level) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = friends.length;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<friends.length;i++){
            for(int j=0;j<friends[i].length;j++){
                adj.get(i).add(friends[i][j]);
            }
        }
        HashSet<Integer> set = new HashSet<>();
        int visited[] = new int[n];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(id,level));
        visited[id]=1;
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int i = p.id;
            int l = p.lev;
            if(l==0){
                set.add(i);
            }
            for(int it:adj.get(i)){
                if(visited[it] != 1 && l>0){
                    visited[it] =1;
                    queue.add(new Pair(it,l-1));
                }
            }
        }
        HashMap<String,Integer> map= new HashMap<>();
        for(int i=0;i<n;i++){
            if(set.contains(i)){
                for(String s:watch.get(i)){
                    map.put(s,map.getOrDefault(s,0)+1);
                }
            }
        }
        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list,(a,b)->{
            if (!a.getValue().equals(b.getValue())){
                return a.getValue() - b.getValue();
            }
            return a.getKey().compareTo(b.getKey());
        }); 
        List<String> ans = new ArrayList<>();
        for(Map.Entry<String,Integer> e : list) {
            ans.add(e.getKey());
        }
        return ans;
    }
}