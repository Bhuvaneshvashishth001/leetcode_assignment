class Solution {
    class Disjoint{
        HashMap<String,String> par = new HashMap<>();
        public void add(String acc){
            par.putIfAbsent(acc, acc);
        }
        public String find(String u){
            if(!par.get(u).equals(u)){
                par.put(u,find(par.get(u)));
            }
            return par.get(u);
        }
        public void union(String u,String v){
            String par_u = find(u);
            String par_v = find(v);
            if (!par_u.equals(par_v)) {
                par.put(par_v, par_u);
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Disjoint ds = new Disjoint();
        HashMap<String, String> email = new HashMap<>();
        for(List<String> acc : accounts){
            String name = acc.get(0);
            String first = acc.get(1);
            for (int i = 1;i < acc.size();i++){
                ds.add(acc.get(i));
                email.put(acc.get(i), name);
                ds.union(first, acc.get(i));
            }
        }
        HashMap<String,TreeSet<String>> map = new HashMap<>();
        for(List<String> acc : accounts){
            String name = acc.get(0);
            for(int i =1;i<acc.size(); i++){
                String parent = ds.find(acc.get(i));
                map.putIfAbsent(parent, new TreeSet<>());
                map.get(parent).add(acc.get(i));
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(String parent:map.keySet()){
            List<String> temp = new ArrayList<>();
            temp.add(email.get(parent));
            temp.addAll(map.get(parent));
            res.add(temp);
        }
        return res;
    }
}