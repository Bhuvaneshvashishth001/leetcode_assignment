class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int len = 0;
        int i=0;
        int j=0;
        Map<Character,Integer> map = new HashMap<>();
        while(j<n){
            while(!map.isEmpty() && map.containsKey(s.charAt(j))){
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                if(map.get(s.charAt(i)) == 0){
                    map.remove(s.charAt(i));
                }
                i++;
            }
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            len = Math.max(len,j-i+1);
            j++;
        }
        return len;
    }
}