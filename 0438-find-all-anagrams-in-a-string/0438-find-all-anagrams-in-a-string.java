class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return list;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int k=0;k<m;k++){
            map.put(p.charAt(k),map.getOrDefault(p.charAt(k),0)+1);
        }
        int count = map.size();
        while(j<n){
            if(map.containsKey(s.charAt(j))){
                map.put(s.charAt(j),map.get(s.charAt(j))-1);
                if(map.get(s.charAt(j)) == 0){
                    count--;
                }
            }
            j++;
            while(count == 0){
                if(map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i),map.get(s.charAt(i))+1);
                    if(map.get(s.charAt(i)) > 0){
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