class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        int i = 0;
        int j = 0;
        int max =  0;
        while(j<n){
            while(map.containsKey(s.charAt(j)) && map.get(s.charAt(j)) == 2){
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                if(map.get(s.charAt(i)) ==0){
                    map.remove(s.charAt(i));
                }
                i++;
            }
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            max= Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}