class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();
        HashMap<Character,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        if(p == null || s == null || s.length() < p.length()){
            return list;
        } 
        for(int i=0;i<m;i++){
            map.put(p.charAt(i),map.getOrDefault(p.charAt(i),0)+1);
        }
        int count = map.size();
        int i=0;
        int j=0;
        while(j<n){
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch,map.getOrDefault(ch,0)-1);
                if(map.get(ch) == 0){
                    count--;
                }
            }
            j++;
            while(count == 0){
                char start = s.charAt(i);
                if(map.containsKey(start)){
                    map.put(start,map.getOrDefault(start,0)+1);
                    if(map.get(start)> 0){
                        count++;
                    }
                }
                if(j-i == p.length()){
                    list.add(i);
                }
                i++;
            }
        }
        return list;
    }
}