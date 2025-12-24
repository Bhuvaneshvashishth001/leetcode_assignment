class Solution {
    public boolean closeStrings(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if(n != m){
            return false;
        }
        Map<Character,Integer> map1 = new HashMap<>();
        for(int i=0;i<n;i++){
            map1.put(word1.charAt(i),map1.getOrDefault(word1.charAt(i),0)+1);
        }
        Map<Character,Integer> map2 = new HashMap<>();
        for(int i=0;i<n;i++){
            map2.put(word2.charAt(i),map2.getOrDefault(word2.charAt(i),0)+1);
        }
        if(!map1.keySet().equals(map2.keySet())){
            return false;
        }
        List<Integer> v1 = new ArrayList<>(map1.values());
        List<Integer> v2 = new ArrayList<>(map2.values());
        Collections.sort(v1);
        Collections.sort(v2);
        return v1.equals(v2);
    }
}