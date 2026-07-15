class Solution {
    public int characterReplacement(String s, int k) {
        int  i = 0 ;
        int  j = 0 ; 
        int  n = s.length() ;
        int maxFreq = 0;
        int maxLen = 0;
        Map<Character,Integer> map = new HashMap<>();
        while(j<n){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            for(Map.Entry<Character,Integer> entry : map.entrySet()){
                maxFreq = Math.max(maxFreq,entry.getValue());
            }
            while((j-i+1) - maxFreq > k){
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                i++;
            }
            maxLen = j-i+1;
            j++;
        }
        return maxLen;
    }
}