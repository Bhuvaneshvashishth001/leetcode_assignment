class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int count = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        while(j<s.length()){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            while(j== n-1 && j-i>=3 && map.containsKey('a') && map.containsKey('b') && map.containsKey('c')){
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                if(map.get(s.charAt(i)) == 0){
                  map.remove(s.charAt(i));
                }
                count++;
                i++;
            }
            while(map.containsKey('a') && map.containsKey('b') && map.containsKey('c')){
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                if(map.get(s.charAt(i)) == 0){
                  map.remove(s.charAt(i));
                }
                count += n-j;
                i++;
            }
            j++;
        }
        return count;
    }
}