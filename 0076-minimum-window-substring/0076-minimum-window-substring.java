class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<m;i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        int i = 0;
        int j = 0;
        int idx = -1;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        while(j<n){
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch) >= 0){
                    count++;
                }
            }
            while(count == m){
                if(j-i+1 < minLen){
                    minLen = j-i+1;
                    idx = i;
                }
                char start = s.charAt(i);
                if(map.containsKey(start)){
                    map.put(start,map.get(start)+1);
                    if(map.get(start) > 0){
                        count--;
                    }
                }
                i++;
            }
            j++;
        }
        if(idx == -1){
            return "";
        }
        return s.substring(idx,idx+minLen);
    }
}